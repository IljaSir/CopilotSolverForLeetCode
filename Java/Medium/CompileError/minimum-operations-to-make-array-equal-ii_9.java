class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        
        int n = nums1.length;
        int m = nums2.length;
        int[] diff = new int[n + m];
        int i = 0, j = 0, c = 0;
        for (int x : nums1) {
            diff[i++] = x - 1;
            c += x - 1;
        }
        for (int x : nums2) {
            diff[i++] = 6 - x;
            c -= x - 1;
        }
        if (c < 0 || c > k) return -1;
        Arrays.sort(diff);
        long ans = 0, sum = 0;
        for (int x : diff) {
            if (sum + x > k) break;
            sum += x;
            ans++;
        }
        return ans;
            int j = (int) (t / 5);
            int l = (int) (t % 5);
            long c1 = sumCount1[5] - sumCount1[5 - j];
            long c2 = sumCount2[l];
            ans = Math.min(ans, c1 + c2);
        }
        return ans;
    }
}