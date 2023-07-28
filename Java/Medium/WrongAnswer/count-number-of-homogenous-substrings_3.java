class Solution {
    public int countHomogenous(String s) {
        
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            int len = j - i;
            int k = 1;
            while (len >= k) {
                ans = (ans + k) % 1000000007;
                len -= k;
                k++;
            }
            i = j - 1;
        }
        return ans;
    }
}