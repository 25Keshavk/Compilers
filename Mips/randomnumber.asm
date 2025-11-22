# Number guessing game that prompts the user to guess a randomly generated number
# between 0 and 99, with the option to exit by entering 100.
# @author	Keshav Kotamraju
# @version	5/6/2024

.data
    prompt: .asciiz "Enter your guess from 0-99, type 100 to end: "
    wrongup: .asciiz "Not quite, the number is bigger than that."
    wrongdown: .asciiz "Not quite, the number is smaller than that."
    right: .asciiz "Congratulations, you won!"
    endmsg: .asciiz "I feel no holes"

.text
.globl main
main:
    # Generate a random number between 0 and 99
    li $v0, 42           
    li $a1, 100          # range 
    syscall
    move $t0, $a0        

    # Game loop
loop:
    # Prompt user to enter a guess
    li $v0, 4
    la $a0, prompt
    syscall

    # Read the user's guess
    li $v0, 5
    syscall
    move $t1, $v0      

    # Print a newline
    li $v0, 11
    li $a0, 10           # ASCII value for newline
    syscall

    # Check if the user wants to end the game
    beq $t1, 100, end

    # Provide feedback based on the guess
    bgt $t0, $t1, higher
    blt $t0, $t1, lower

    # If guess is correct
    la $a0, right
    li $v0, 4
    syscall

    # Print a newline
    li $v0, 11
    li $a0, 10           
    syscall
    j end                

# too low
higher:
    la $a0, wrongup
    li $v0, 4
    syscall

    # Print a newline
    li $v0, 11
    li $a0, 10           
    syscall
    j loop               

# too high
lower:
    la $a0, wrongdown
    li $v0, 4
    syscall

    li $v0, 11
    li $a0, 10           
    syscall
    j loop               

# End game
end:
    la $a0, endmsg
    li $v0, 4
    syscall
    li $v0, 10
    syscall
