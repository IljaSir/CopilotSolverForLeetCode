class Solution {
    public int mostFrequent(int[] nums, int key) {
        
        int max = 0;
        int maxVal = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == key && i + 1 < nums.length) {
                int val = nums[i + 1];
                map.put(val, map.getOrDefault(val, 0) + 1);
                if(map.get(val) > max) {
                    max = map.get(val);
                    maxVal = val;
                }
            }
        }
        return maxVal;
    }
}