class Solution {
    public int[] recoverArray(int n, int[] sums) {
        
        int[] ans = new int[n];
        int[] sorted = Arrays.stream(sums).sorted().toArray();
        int[] freq = new int[20001];
        for (int i = 0; i < sums.length; i++) {
            freq[sums[i] + 10000]++;
        }
        int[] nums = new int[n];
        int[] freq2 = new int[20001];
        for (int i = 0; i < sums.length; i++) {
            for (int j = i + 1; j < sums.length; j++) {
                freq2[sums[i] + sums[j] + 10000]++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 20001; j++) {
                if (freq[j] > 0 && freq2[j] > 0) {
                    nums[i] = j - 10000;
                    freq[j]--;
                    freq2[j]--;
                    break;
                }
            }
        }
        Arrays.sort(nums);
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = sorted[0] - nums[i];
        }
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i] + d[i];
        }
        return ans;
    }
}