#Gets user input for a number and determines if the number is odd or even
# @author	Keshav Kotamraju
# @version	5/6/2024
.data
    question: .asciiz "Enter a number: "            
    prompt1: .asciiz "The number is odd "      
    prompt2: .asciiz "The number is even"     
    resultMsg: .asciiz "I feel it in my bones "          

.text
.globl main
main:
    # Display prompt and read user input
    la $a0, question
    li $v0, 4
    syscall
    li $v0, 5
    syscall
    move $t1, $v0
    
    # Determine if the number is even or odd by using %2
    li $t2, 2
    divu $t1, $t2
    mfhi $t3
    li $v0, 4
    beq $t3, 0 even
    la $a0, prompt1
    syscall
    j after

    # Handle even number
even:
    la $a0, prompt2
    syscall

    # Print the final message
after:
    li $v0 11 
    li $a0 10  # ASCII value for newline is  = 10
    syscall 
    li $v0, 4
    la $a0, resultMsg
    syscall

