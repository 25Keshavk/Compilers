#Plays Took Her To The O by King Von instrumental without the lyrics
# @author	Keshav Kotamraju
# @version	5/6/2024
.globl main

main:
    
    li $v0 31
    li $a0 40
    li $a1 2000 
    li $a2 1
    li $a3 127
    syscall
    
    li $a0 28
    syscall
    
    # b
    li $v0 31
    li $a0 59
    li $a1 500
    li $a3 80
    syscall
    
    li $v0 32
    li $a0 400 #pause between notes
    syscall
    
    # g
    li $v0 31
    li $a0 67
    syscall
    
    li $v0 32
    li $a0 400
    syscall
    
    # f
    li $v0 31
    li $a0 66
    syscall
    
    li $v0 32
    li $a0 400
    syscall
    
    # b
    li $v0 31
    li $a0 59
    syscall
    
    li $v0 32
    li $a0 400
    syscall
    
    #c
    li $v0 31
    li $a0 60
    syscall
    
    li $v0 32
    li $a0 400
    syscall
    
    #c
    li $v0 31
    li $a0 60
    syscall
    
    li $v0 32
    li $a0 400
    syscall
    
    #e
    li $v0 31
    li $a0 64
    syscall
    
    li $v0 32
    li $a0 400
    syscall
    
    #c
    li $v0 31
    li $a0 60
    syscall
    
    li $v0 32
    li $a0 400
    syscall
    
    # b
    li $v0 31
    li $a0 59
    syscall
    
    li $v0 32
    li $a0 400
    syscall
    
    # g
    li $v0 31
    li $a0 67
    syscall
    
    li $v0 32
    li $a0 400
    syscall
    
    # f
    li $v0 31
    li $a0 66
    syscall
    
    li $v0 32
    li $a0 400
    syscall
    
    # b
    li $v0 31
    li $a0 59
    syscall
    
    li $v0 32
    li $a0 400
    syscall
    
    #c
    li $v0 31
    li $a0 60
    syscall
    
    li $v0 32
    li $a0 400
    syscall
    
    #e
    li $v0 31
    li $a0 64
    syscall
    
    li $v0 32
    li $a0 400
    syscall
    
    # f
    li $v0 31
    li $a0 66
    syscall
    
    li $v0 32
    li $a0 400
    syscall
    
    #e
    li $v0 31
    li $a0 64
    syscall
    
    li $v0 32
    li $a0 400
    syscall
    
    j main
	
