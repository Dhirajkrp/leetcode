## 220. Contains Duplicate III

You are given an integer array nums and two integers indexDiff and valueDiff.

Find a pair of indices (i, j) such that:

i != j,
abs(i - j) <= indexDiff.
abs(nums[i] - nums[j]) <= valueDiff, and
Return true if such pair exists or false otherwise.

### Example 1:

Input: nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
Output: true
Explanation: We can choose (i, j) = (0, 3).
We satisfy the three conditions:
i != j --> 0 != 3
abs(i - j) <= indexDiff --> abs(0 - 3) <= 3
abs(nums[i] - nums[j]) <= valueDiff --> abs(1 - 1) <= 0

### Example 2:

Input: nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
Output: false
Explanation: After trying all the possible pairs (i, j), we cannot satisfy the three conditions, so we return false.

### Constraints:

2 <= nums.length <= 105
-109 <= nums[i] <= 109
1 <= indexDiff <= nums.length
0 <= valueDiff <= 109

```java
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {


        // if the valuediff is 0 it becomes a contains duplicate problem.
        // if the valuediff is 0 the only way it can have a pair if the array has duplicate values.
       if(valueDiff ==0){
           HashSet<Integer> set = new HashSet();
           for(int i=0 ;i< nums.length;i++){
               set.add(nums[i]);
           }
           if(set.size() == nums.length) return false;
       }

        for(int i=0 ; i< nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(j > i+indexDiff ) break;

                int idiff = Math.abs(i-j);
                int vdiff = Math.abs(nums[i] - nums[j]);
                if(idiff <= indexDiff && vdiff <= valueDiff)
                    return true;
            }
        }



        return false;
    }
}

```
