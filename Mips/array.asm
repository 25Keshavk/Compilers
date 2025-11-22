# Accepts 10 numbers from user, stores them in an array, 
# and calculates the sum, average, minimum, and maximum of these values.
# @author	Keshav Kotamraju
# @version	5/6/2024
.data
    prompt: .asciiz "Enter a number: "
    sum: .asciiz "Sum: "
    avg: .asciiz "Average: "
    min: .asciiz "Minimum: "
    max: .asciiz "Maximum: "
    .align 2
    array: .space 40  # Space for 10 integers, 4 bytes each

.text
.globl main
main:
    # Initialization
    la $t0, array  # Address for array
    li $t1, 0      # Index for loop
    li $t2, 0      # Store sum

    # Reading input loop
    li $t5, 10     # Count to 10
loop:
    bge $t1, $t5, metrics  # Exit loop after 10 numbers
    li $v0, 4
    la $a0, prompt
    syscall

    li $v0, 5
    syscall
    sw $v0, 0($t0)  
    add $t2, $t2, $v0  

    addiu $t0, $t0, 4  
    addiu $t1, $t1, 1  
    j loop

# Calculations for sum, average, min, and max
metrics:
    # Calculate average
    li $t3, 0
    div $t2, $t5  
    mflo $t3 

    la $t0, array  # Reset array pointer
    li $t1, 0      # Reset index
    lw $t4, 0($t0)
    move $t6, $t4  
    move $t7, $t4 

    # Find min and max in array
min_max_loop:
    bge $t1, $t5, result 

    lw $t4, 0($t0)  
    blt $t4, $t6, change_min
    bgt $t4, $t7, change_max

    # Go to next element
    addiu $t0, $t0, 4
    addi $t1, $t1, 1
    j min_max_loop

change_min:
    move $t6, $t4  
    j min_max_loop

change_max:
    move $t7, $t4  
    j min_max_loop

result:
    # Print sum
    li $v0, 4
    la $a0, sum
    syscall
    li $v0, 1
    move $a0, $t2
    syscall
    li $v0, 11
    li $a0, 10           
    syscall

    # Print average
    li $v0, 4
    la $a0, avg
    syscall
    li $v0, 1
    move $a0, $t3
    syscall
    li $v0, 11
    li $a0, 10           
    syscall

    # Print minimum
    li $v0, 4
    la $a0, min
    syscall
    li $v0, 1
    move $a0, $t6
    syscall
    li $v0, 11
    li $a0, 10           
    syscall

    # Print maximum
    li $v0, 4
    la $a0, max
    syscall
    li $v0, 1
    move $a0, $t7
    syscall
    li $v0, 11
    li $a0, 10           
    syscall

    # Exit program
    li $v0, 10
    syscall
