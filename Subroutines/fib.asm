# Outputs nth number of fibbonaci using recursion and subroutines
# @author Keshav Kotamraju
# @version 5/23/24
.data
	prompt: .asciiz "Enter a number "
.text
.globl main
main:
	#prompt
	li $v0, 4
	la $a0, prompt
	syscall
	li $v0, 5
	syscall
	
	move $a0, $v0
	jal fib
	move $a0, $v0
	
	#result
	li $v0, 1
	syscall
	
	li $v0, 10
	syscall

fib:
	bgt $a0, 1, recur #go again if a0 > 1
	move $v0, $a0
	jr $ra
	
recur:
	subu $sp, $sp, 12
	sw $ra, ($sp)
	sw $a0, 4($sp)
	
	#fib(n-1)
	subu $a0, $a0, 1
	jal fib
	sw $v0, 8($sp) #Stores val
	
	#fib(n-2)
	lw $a0, 4($sp)
	subu $a0, $a0, 2
	jal fib
	
	#Pops vals to add them 
	lw $t0, 8($sp)
	add $v0, $t0, $v0
	lw $ra, ($sp)
	addu $sp, $sp, 12
	jr $ra
