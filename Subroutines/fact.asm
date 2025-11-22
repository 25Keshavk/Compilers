# Uses recursion to calculate factorial of a given number
# @author Keshav Kotamraju
# @version 5/23/24
.data
	prompt: .asciiz "Enter a number: "
	num: .word 0
	ans: .word 0
.text 
.globl main
main: 
	#prompt
	la $a0, prompt
	li $v0 4
	syscall
	
	#gets num
	li $v0, 5
	syscall
	
	#loads value for subroutine
	sw $v0, num
	lw $a0, num 
	
	jal fact #result in v0
	
	sw $v0, ans
	lw $a0, ans
	li $v0, 1
	syscall
	li $v0, 10
	syscall
	
fact:
	subu $sp, $sp, 8
	sw $ra, ($sp)
	sw $s0, 4($sp)
	
	#Base Case return 1 when a0 = 0
	li $v0, 1
	beq $a0, 0, factend
	
	#Else, store num in s0, a0 = a0 - 1
	move $s0, $a0
	subu $a0, $a0, 1
	jal fact
	
	#After recursion calls end, does 1*2*...n
	mul $v0, $s0, $v0
	
factend:
	lw $ra, ($sp)
	lw $s0, 4($sp)
	
	addu $sp, $sp, 8
	jr $ra
	
	
