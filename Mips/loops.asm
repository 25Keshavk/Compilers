#prints a series of numbers within a user-defined range and step, along with a message.
# @author	Keshav Kotamraju
# @version	5/6/2024
.data
    promptLow: .asciiz "Enter the low end of the range: "
    promptHigh: .asciiz "Enter the high end of the range: "
    promptStep: .asciiz "Enter the step value: "
    keeploop: .asciiz "value: "
    whynot: .asciiz "Yes I am rectangular"
    
.text
.globl main
main:
    # Prompt and read the low end of the range
    li $v0, 4
    la $a0, promptLow
    syscall
    li $v0, 5
    syscall
    move $t0, $v0 

    # Prompt and read the high end of the range
    li $v0, 4
    la $a0, promptHigh
    syscall
    li $v0, 5
    syscall
    move $t1, $v0  

    # Prompt and read the step value
    li $v0, 4
    la $a0, promptStep
    syscall
    li $v0, 5
    syscall
    move $t2, $v0  
    
    # Loop to process and print numbers in the range
    loop:
        blt $t1, $t0, break  # Break the loop if $t0 >= $t1
        li $v0, 4
        la $a0, keeploop
        syscall

        li $v0, 1
        move $a0, $t0
        syscall  
        li $v0 11 
    	li $a0 10  # ASCII value for newline is = 10
    	syscall

        addu $t0, $t0, $t2  

        j loop 

   
    break:
        li $v0, 4
        la $a0, whynot
        syscall 
        li $v0, 10
        syscall 
