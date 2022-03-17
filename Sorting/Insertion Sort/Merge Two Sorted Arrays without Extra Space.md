## Merge Two SORTED Arrays withouut Extra Space

We are given two sorted arrays.
We need to merge these two arrays such that
initial numbers after complete sorting are in the first array.
Extra space allowed is O(1)

Eg. 
```
Input :
   ar1[] ={10}
   ar2[] = {2, 3}

Output:
   ar1[] = {2}
   ar2[] = {3, 10}
```

```
Input :
   ar1[] ={1, 5, 9, 10, 15, 20}
   ar2[] = {2, 3, 8, 13}

Output:
   ar1[] = {1, 2, 3, 5, 8, 9}
   ar2[] = {10, 13, 15, 20}
```

#### If Extra space was allowed:
We could take an array of size M+N and sort it and place the elements back in original arrays
O(M+N)log(M+N) + O(M) + O(N)

####  If Extra space wasn't allowed:
- We can think of Iterating in arr1
	- whenever we encounter an element is greater than the first element of array2
	- swap it
	- Rearrange the arr2 in a sorted manner [ Insertion sort for the misplaced element ]


Time :: O(N*M) {(Iteration through array1)*(ReOrder of 2nd array)} 
Space :: O(1)

a1 = {(1), 4, 7, 8, 10}  n1=5  
a2 = {(2), 3, 9}         n2=3  
1<2 hence no swap 

a1 = {1, (4), 7, 8, 10}  
a2 = {(2), 3, 9} 
4>2 hence swap -> {1, (2), 7, 8, 10}
               -> {(4), 3, 9} --> insertion sort --> {3, 4, 9}

a1 = {1, 2, (7), 8, 10}
a2 = {(3), 4, 9}
7>3 hence swap -> {1, 2, (3), 8, 10}
               -> {(7), 4, 9} --> insertion sort --> {4, 7, 9}

a1 = {1, 2, 3, (8), 10}  
a2 = {(4), 7, 9}  
8>4 hence swap -> {1, 2, 3, (4), 10} 
               -> {(8), 7, 9} --> insertion sort --> {7, 8, 9}

a1 = {1, 2, 3, 4, (10)}  
a2 = {(7), 8, 9}  
7<10 hence no swap 

we reached the end of the a1, hence we stop