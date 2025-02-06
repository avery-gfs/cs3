You should implement `search` as a recursive function (it should contain one or
more calls to itself).

As with the fibonacci function `f(n) = f(n - 1) + f(n - 2)` you'll want to think
about how `search(board, r, c)` can be constructed as a recursive function.

You'll need to figure out when `search` should call itself, and when it should
return a predefined result -- that is, identify one ore more "base cases", like
`f(0)` and `f(1)` in the fibonacci problem.

Unlike previous recursive functions we've looked at, search will also make
modifications its `board` argument, sometimes temporarily and sometimes
permanently.

You can write a maze solver using recursion or without using it, but you'll
probably find that the recursive solutions is more elegant!

![maze animation](maze.gif)
