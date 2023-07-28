class Solution {
    public int partitionArray(int[] nums, int k) {
        
        int n = nums.length;
        int[] count = new int[100001];
        for (int num : nums) count[num]++;
        int[] prefix = new int[100001];
        for (int i = 1; i < prefix.length; i++) prefix[i] = prefix[i-1] + count[i];
        int result = n;
        for (int i = 1; i < prefix.length; i++) {
            int l = i;
            int r = 100000;
            while (l < r) {
                int mid = (l + r) / 2;
                if (prefix[mid] - prefix[i-1] <= n - prefix[mid]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (l - i <= k) result = Math.min(result, prefix[l] - prefix[i-1]);
        }
        return result;
    }
}