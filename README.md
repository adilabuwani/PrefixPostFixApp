# PrefixPostFixApp:
  The prefixPostFix app appreciates an important application for one of these structures.
This application is parsing (that is, analyzing) arithmetic expressions such as 2+3 or
2*(3+4) The storage structure it uses is the stack.
   The App converts an infix expression to postfix using the following algorithm above...

The Algorithm is as follows:

Operand: Write it to output (postfix)
Open parenthesis ( Push it on stack
Close parenthesis ) While stack not empty, repeat the following:
Pop an item,
If item is not (, write it to output
Quit loop if item is (
Operator (opThis) If stack empty,
Push opThis
Otherwise,
While stack not empty, repeat:
Pop an item,
If item is (, push it, or
If item is an operator (opTop), and
If opTop < opThis, push opTop, or
If opTop >= opThis, output opTop
Quit loop if opTop < opThis or item is (
Push opThis
No more items While stack not empty,
Pop item, output it.
