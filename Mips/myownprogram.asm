#program that takes user input and multiplies two given numbers together
# @author	Keshav Kotamraju
# @version	5/6/2024
.data
    prompt1: .asciiz "Enter first number: "
    prompt2: .asciiz "Enter second number: "
    resultMsg: .asciiz "Product: "
    res2: .asciiz "I am rectangula"
.text
.globl main
main:
    li $v0, 4
    la $a0, prompt1
    syscall

   
    li $v0, 5
    syscall
    move $t0, $v0 


    li $v0, 4
    la $a0, prompt2
    syscall

    
    li $v0, 5
    syscall
    move $t1, $v0 

    # Multiply the numbers
    mul $t2, $t0, $t1 

    # Product msg
    li $v0, 4
    la $a0, resultMsg
    syscall

    # Print the result
    move $a0, $t2
    li $v0, 1
    syscall
    li $v0 11 
    li $a0 10  # ASCII value for newline is 10
    syscall
    la $a0, res2
    li $v0, 4
    syscall

    li $v0, 10
    syscall




