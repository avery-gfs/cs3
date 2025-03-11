TO DO: use functions for instructions not DSL

All registers begin program execution initialized to 0.

Instructions with a dest parameter store their result in the register dest. These instructions require that dest is a register name. All other arguments can be register names or number literals.

Comparison instructions produce a result of 0 if the comparison is false and 1 if the comparison is true.

Logical instructions interpret arguments of 0 as false and arguments of any other value as true.

Jumps are applied relative to the instruction position. Conditional jumps whose condition is false proceed to the next instruction.

All numbers are integers (division results are truncated).

MATH:

add dest n      (add n to dest)
sub dest n      (subtract n from dest)
mul dest n      (multiply dest by n)
div dest n      (divide dest by n)
mod dest n      (compute dest modulo n)

COMPARISON:

eq  dest n      (check if dest equals n)
lt  dest n      (check if dest is less than n)
gt  dest n      (check if dest is greater than n)

LOGICAL:

and dest alt    (compute logical 'and' of dest and alt)
or  dest alt    (compute logical 'or' of dest and alt)
not dest        (compute logical 'not' of dest)

JUMPS:

jmp n        (jump by n instructions)
jeq n a b    (jump by n instructions if a equals b)
jne n a b    (jump by n instructions if a does not equal b)

HALT:

halt    (stop program execution immediately)

SET:

set dest n    (set the value of dest to n)

OUTPUT:

log n      (print n as a number on a new line)
print n    (print n as a character in the current line)

MEMORY:

load dest index    (load memory location index into dest)
store src index    (store src in memory location index)
init n0 n1 ...     (set memory array to a given sequence of values)
