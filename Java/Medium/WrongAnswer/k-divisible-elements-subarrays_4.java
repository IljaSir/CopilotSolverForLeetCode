class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        
        int n = nums.length;
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = nums[i] % p;
        }
        int[] c = new int[p];
        int[] d = new int[p];
        int l = 0;
        int s = 0;
        int t = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            while (l <= i && c[r[i]] >= k) {
                c[r[l]]--;
                if (c[r[l]] == 0) {
                    t -= d[r[l]];
                }
                s -= r[l];
                l++;
            }
            c[r[i]]++;
            s += r[i];
            d[r[i]]++;
            t += d[r[i]];
            count += t;
        }
        return count;
    }
}