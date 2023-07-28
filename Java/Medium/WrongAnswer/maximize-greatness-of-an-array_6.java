class Solution {
    public int maximizeGreatness(int[] nums) {
        
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (sorted[i] > nums[i]) {
                ans++;
            }
        }
        return ans;
    }
}