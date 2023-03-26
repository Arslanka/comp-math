
<h1 style="text-align: center;">Computational math labs ITMO</h1>


# 1) *Method of simple iterations (*SYSTEM OF LINIEAR EQUATIONS*)*

For iterative methods, it should be implemented:

- The accuracy is set from the keyboard/file
- Checking the diagonal predominance (if there is no diagonal predominance in the original matrix, make a permutation of rows/columns until the predominance is reached). If it is impossible to achieve diagonal predominance - display the corresponding message.
- Output of the vector of unknowns: 𝑥1, 𝑥2, …, 𝑥𝑛
- Output of the number of iterations for which the solution was found.
- Inaccuracy vector output: |𝑥𝑖 (𝑘) − 𝑥𝑖 (𝑘−1) |

# Method description

The method consists in finding the approximate value of the value of the next approximation, which is more accurate. The *SYSTEM OF LINIEAR EQUATIONS* given to us needs to be reduced to a form with a diagonal predominance, then we need to express the unknowns. As the first approximation, we can take the free terms of *SYSTEM OF LINIEAR EQUATIONS*, substituting these values we find the unknowns, which, in turn, will form the second approximation. In the same way, we find the third approximation and so on until the solution satisfies the accuracy. It is considered as the maximum difference of individual solutions between two consecutive iterations.


# Program code

[https://github.com/Arslanka/comp-math/tree/main/comp-math/MethodOfSimpleIterations](https://github.com/Arslanka/comp-math/tree/main/comp-math/MethodOfSimpleIterations)

# 2) *Method of half-division (*NON-LINEAR EQUATION*)
