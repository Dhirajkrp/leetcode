class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int upperBound = nums.length/3 ;

        HashMap<Integer , Integer> map = new HashMap<>();

        for(int i : nums){
            map.put(i , map.getOrDefault(i,0) +1);
        }
        
        List<Integer> ans = new ArrayList<>();
        for(Integer x : map.keySet()){  
            if(map.get(x) > upperBound){
                ans.add(x);
            }
        }

        return ans;
    }
}