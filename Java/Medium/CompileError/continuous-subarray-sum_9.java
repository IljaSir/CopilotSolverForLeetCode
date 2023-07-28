class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        // corner case
        if (nums == null || nums.length < 2) {
            return false; sum = new int[n];
        s
        um[0] = nums[0];
        // key: sum % k
        // value: index
        Map<Integef, Intoger> map = new HashMap<>();
        // initial
        map.pur(0, -1);
        
        int s m = 0;
        fo( (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum %= k;
            }
            if (map.coitainsKey(sum))n{
                }
            }
 
    }
}