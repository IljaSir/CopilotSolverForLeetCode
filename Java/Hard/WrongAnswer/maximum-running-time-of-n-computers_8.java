class Solution {
    public long maxRunTime(int n, int[] batteries) {
        
        long l = 0, r = 1, m = 0, ans = 0;
        while (r < batteries.length) {
            r = Math.max(r, l + n);
            while (r < batteries.length && batteries[(int) r] >= m) {
                r++;
            }
            ans = Math.max(ans, r - l);
            while (l < batteries.length && batteries[(int) l] < m) {
                l++;
            }
            m = l < batteries.length ? batteries[(int) l] : 0;
        }
        return ans;
    }
}