#Returns the sum of a list
#author Keshav Kotamraju
#version 5/23/24
.data

.text
.globl main



sumlist:
    #if list is null, return 0
    beq $a0, $zero, zero


    lw $t0, 0($a0)  


    lw $a1, 4($a0)

    # save $ra on the stack
    subu $sp, $sp, 4
    sw $ra, 0($sp)

    # recursive call
    jal sumlist

    lw $ra, 0($sp)
    addu $sp, $sp, 4

    # Add the current value
    add $v0, $v0, $t0

    # Return from the subroutine
    jr $ra

zero:
    li $v0, 0
    jr $ra


