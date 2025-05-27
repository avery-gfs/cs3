Wikipedia description: https://en.wikipedia.org/wiki/Tower_of_Hanoi#Iterative_solution

`height`: Number of disks in the puzzle. Each disk is represented with a number from `1` to `height`, where the `1` disk is the smallest.

`towers`: List of towers. Towers are accessed with their index (`0`, `1`, or `2`) in the towers list. Each tower is a list of numbers representing the disks in the tower from bottom to top, for example in the following configuration:

```
      ░             ░             ░       
      ░             ░             ░       
      ░             ░             ░       
      ░             ░             ░       
      ░            ▇▇▇            ░       
 ▇▇▇▇▇▇▇▇▇▇▇      ▇▇▇▇▇           ░       
▇▇▇▇▇▇▇▇▇▇▇▇▇    ▇▇▇▇▇▇▇      ▇▇▇▇▇▇▇▇▇
```

```py
towers = [[6, 5], [3, 2, 1], [4]]
```

`canMove(src, dest)`: Checks if we can move a disk from the `src` tower to the `dest` tower. For example, with the following configuration:


```
       ░             ░             ░       
       ░             ░             ░       
       ░             ░             ░       
    ▇▇▇▇▇▇▇          ░             ░       
   ▇▇▇▇▇▇▇▇▇         ░             ░       
  ▇▇▇▇▇▇▇▇▇▇▇        ░            ▇▇▇      
 ▇▇▇▇▇▇▇▇▇▇▇▇▇       ░           ▇▇▇▇▇ 
```

```py
canMove(0, 1) == True
canMove(2, 0) == True
canMove(2, 1) == True
canMove(1, 0) == False
canMove(0, 2) == False
canMove(1, 2) == False
```

`step(n)`: Gets called `63` times with each of the numbers `0` through `62`. Each call to `step` moves a single disk. `step` should use the value of `n % 3` along with `canMove` to determine which move to make according to the following iterative algorithm:

https://en.wikipedia.org/wiki/Tower_of_Hanoi#Iterative_solution
