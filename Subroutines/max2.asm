# Takes in two integers and returns the greater value
# @author Keshav Kotamraju
# @version 5/23/24
.data
	prompt: .asciiz "Enter a number: "
	prompt2: .asciiz "Enter another number: "
.text
.globl main
main:
	#prompt
	la $a0, prompt 
	li $v0, 4
	syscall
	
	#gets and stores first number in a1
	li $v0, 5
	syscall
	
	move $a1, $v0
	
	#prompt2
	la $a0, prompt2 
	li $v0, 4
	syscall
	
	#gets and stores second number in a2
	li $v0, 5
	syscall
	
	move $a2, $v0
	
	subu $sp, $sp, 4
	sw $ra, ($sp)#stores return address in stack
	
	jal max2 #Jumps to max2 subroutine
	
	lw $ra ($sp) #gets return address from the stack
	addu $sp $sp 4
	
	move $a0, $v0
	li $v0 1
	syscall
	
	li $v0, 10
	syscall		
max2:
	bgt $a1, $a2, maxDone	#Checks if the first number is greater than the second
	
	move $a1, $a2		#Stores greater num in a1
maxDone:
	move $v0, $a1
	
	jr $ra 
