class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int[] map = new int[k];
        int sum = 0;
        int count = 0;
        map[0] = 1;
        for (int num : nums) {
            sum += num;
            int mod = (sum % k + k) % k;
            if (map[mod] > 0) {
                count += map[mod];
            }
            map[mod]++;
        }
        return count;
    }
}