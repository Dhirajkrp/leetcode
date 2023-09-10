## Jump Game ii

**Problem Statement: Minimum Number of Jumps**

You are given a 0-indexed array of integers `nums` of length `n`. You are initially positioned at `nums[0]`.

Each element `nums[i]` represents the maximum length of a forward jump from index `i`. In other words, if you are at `nums[i]`, you can jump to any `nums[i + j]` where:

- `0 <= j <= nums[i]` and
- `i + j < n`

Return the minimum number of jumps to reach `nums[n - 1]`. The test cases are generated such that you can reach `nums[n - 1]`.

**Example 1:**

Input: `nums = [2,3,1,1,4]`
Output: `2`
Explanation: The minimum number of jumps to reach the last index is `2`. Jump `1` step from index `0` to `1`, then `3` steps to the last index.

**Example 2:**

Input: `nums = [2,3,0,1,4]`
Output: `2`

**Constraints:**

- `1 <= nums.length <= 10^4`
- `0 <= nums[i] <= 1000`
- It's guaranteed that you can reach `nums[n - 1]`.

---

## Approach:

```java
class Solution {
    public int jump(int[] nums) {
        if(nums.length ==1) return 0;
        int n = nums.length-1 , current =0;
        int steps =0 , i=0;
       while(i< nums.length){
           int max =0;
           int maxIndex = -1;
           for(int j = 1 ; j <= nums[i] ;j++){
               
               if(current+j >= n){
                   return steps+1;
               }

               if(nums[i+j] >= max){
                   max = nums[i+j];
                   maxIndex = i+j;
               }

           }
            current = maxIndex;
            i = current;
            steps++;
       }

       return steps; 
    }
}


```

This was my initial approach after some minute update , the idea was to check if we can reach the end from the current position or not , if we can just return the steps  taken , and if not move to the index who has the maximum jums available , because thats our best chance to get the minimun number of jumps.

But jumping to the max value is not always the  best approach .
For example:

Input: `nums = [10,9,8,7,6,5,4,3,2,1,1,0]`
Output: `2`
In this the minimum jumps is jumping from the `0th` index to the `10th` index and then making the last jump . 
But if we follow going to the largest valued index , we will end up making 10 jumps . moving form 10 to 9 to 8 and so on. 


The second apprach was similar to the BFS using two pointers , for each vaule ,we use the two poniters left and right to define the range of jumps it can cover , after that we keep on updating the window as `left = right+1` and for the right we find the max jump which can be taken from that range.

```java
class Solution {
    public int jump(int[] nums) {
        int res = 0 ,left = 0 ,right =0;
        while(right < nums.length -1){
            int farthest =0;
            for(int i=left ; i<=right;i++){
                farthest = Math.max(farthest , i+nums[i]);
            }
            left = right+1;
            right = farthest;
            res++;
        }
        return res;
    }
}
```