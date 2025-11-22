	.data

	count: .word 0
	.text
.globl main
main: #QTSPIM will automatically look for main

	li $v0, 1
	sw $v0 count
loop1:
	la $t0 count
lw $v0 ($t0)
	subu $sp $sp 4
 #push $v0
sw $v0, ($sp)
	li $v0, 15
	lw $t0, ($sp)
addu $sp $sp 4
	bgt $t0 $v0 eloop2
	la $t0 count
lw $v0 ($t0)
	
move $a0 $v0
li $v0 1
syscall,
 li $v0 11 
li $a0 10  
syscall
	la $t0 count
lw $v0 ($t0)
	subu $sp $sp 4
 #push $v0
sw $v0, ($sp)
	li $v0, 1
	lw $t0, ($sp)
addu $sp $sp 4
	addu $v0 $t0 $v0
	sw $v0 count
	j loop1
eloop2:
	# future code will go here
li $v0 10
syscall # halt
