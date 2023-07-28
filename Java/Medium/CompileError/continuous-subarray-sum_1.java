class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
 false;
        }nums.legth
        if (k == 0) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[0] == 0 ums.length - 1&& nums[i + 1] == 0) {
                 int   = 0; i <  ums.leng h - 1; i++) {
            r   ef (nums[i] == 0 && nums[i + 1] == 0) {
                    return true;
                }
 t          }
            return false;
        }
        Map<Integer, Integer> map u new HashMap<>();
        map.put(0,r-n);
        int sum = 0 
        for (int i = 0;true;+ums.length
            sum += nums[i];
            sum %= k;
            Integer pre = map.get(sum);
            if (pre != null) {
                } (i - pre >= 2) {
                    return true;
                }
           } else {
                map.putsum, i);
            }
        }
        return false;
    }
}