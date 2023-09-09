## 902 Fruit Into Baskets:

**Problem Statement:**

You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array `fruits` where `fruits[i]` is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

1. You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
2. Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
3. Once you reach a tree with fruit that cannot fit in your baskets, you must stop.

Given the integer array `fruits`, return the maximum number of fruits you can pick.

**Examples:**

**Example 1:**

Input: `fruits = [1,2,1]`
Output: `3`
Explanation: We can pick from all 3 trees.

**Example 2:**

Input: `fruits = [0,1,2,2]`
Output: `3`
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].

**Example 3:**

Input: `fruits = [1,2,3,2,2]`
Output: `4`
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].

**Constraints:**

- 1 <= `fruits.length` <= 105
- 0 <= `fruits[i]` < `fruits.length`

## Solution:

```java
class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap();
        int basket = 0 ,count = 0 , ans= 0 , left = 0 ,right=0;

        for(right=0 ;right< fruits.length;right++){
            int curr = fruits[right];
            map.put(curr , map.getOrDefault(curr ,0)+1);
            count++;

            while(map.size() >2){
                int start = fruits[left];
                map.put(start , map.get(start)-1);
                if(map.get(start) ==0){
                    map.remove(start);
                    basket--;
                }
                count--;
                left++;
            }
            ans  = Math.max(ans, count);
        }

    return ans;
    }
}
```

## Explanation of the code:

1. The code uses a sliding window approach to find the maximum number of fruits that can be collected while maintaining the constraints.

2. It initializes a hashmap `map` to keep track of the counts of each fruit type encountered in the sliding window.

3. The `left` and `right` pointers represent the two ends of the sliding window. `basket` keeps track of the number of distinct fruit types in the basket, and `count` keeps track of the total number of fruits collected.

4. The code iterates through the array from left to right using the `right` pointer.

5. For each tree (represented by `curr`), it updates the count of that fruit type in the hashmap `map`.

6. If the number of distinct fruit types in the basket exceeds 2, the code enters a while loop to shrink the sliding window from the left side. It removes fruits from the left side until there are at most 2 distinct fruit types in the basket.

7. The code continuously updates the maximum number of fruits collected (`ans`) as it moves through the array.

8. Finally, it returns the maximum number of fruits that can be collected according to the given rules.

This code effectively finds the longest subarray with at most two distinct elements in an array and returns its length, which represents the maximum number of fruits that can be collected.
