class Solution {
    public int repeatedNTimes(int[] nums) {
        
        int n = nums.length/2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                int count = map.get(nums[i]);
                if (count == n - 1){
                    return nums[i];
                }
                map.put(nums[i], count + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        return 0;
    }
}