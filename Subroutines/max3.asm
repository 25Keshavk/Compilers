# Returns the greatest of 3 values given by user
# @author Keshav Kotamraju
# @version 5/23/24
.data
	prompt: .asciiz "Enter a number: "
	prompt2: .asciiz "Enter a second number: "
	prompt3: .asciiz "Enter a third number: "
.text
.globl main
main:
	#prompt
	la $a0, prompt 
	li $v0, 4
	syscall
	
	#gets and stores num1 in a1
	li $v0, 5
	syscall
	
	move $a1, $v0
	
	#prompt2
	la $a0, prompt2 
	li $v0, 4
	syscall
	
	#gets and stores num2 in a2
	li $v0, 5
	syscall
	
	move $a2, $v0
	
	#prompt3
	la $a0, prompt3 
	li $v0, 4
	syscall
	
	#gets and stores num3 in a3 $a3
	li $v0, 5
	syscall
	
	move $a3, $v0
	
	subu $sp $sp 4
	sw $ra ($sp)
	
	jal max3
	
	lw $ra ($sp)
	addu $sp $sp 4
	
	#Prints the max of the 3 nums
	move $a0, $v0
	li $v0 1
	syscall
	
	li $v0, 10
	syscall	

max3:
	subu $sp $sp 4
	sw $ra ($sp)
	
	jal max2
	
	lw $ra ($sp)
	addu $sp $sp 4
	move $a1, $v0
	move $a2, $a3
	subu $sp $sp 4
	sw $ra ($sp)
	
	jal max2
	
	lw $ra ($sp)
	addu $sp $sp 4
	
	jr $ra
	
max2:
	bgt $a1, $a2, maxDone	#Checks if num1 > num2
	
	move $v0, $a2
	jr $ra
maxDone:
	move $v0, $a1		
	
	jr $ra 			
