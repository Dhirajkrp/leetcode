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
