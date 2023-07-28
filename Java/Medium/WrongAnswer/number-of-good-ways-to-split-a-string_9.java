class Solution {
    public int numSplits(String s) {
        
        int n = s.length();
        int[] left = new int[n];
        int[] right = new int[n];
        int[] count = new int[26];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            count[s.charAt(i) - 'a']++;
            left[i] = count[s.charAt(i) - 'a'];
        }
        count = new int[26];
        for (int i = n - 1; i >= 0; --i) {
            count[s.charAt(i) - 'a']++;
            right[i] = count[s.charAt(i) - 'a'];
        }
        for (int i = 1; i < n; ++i) {
            if (left[i - 1] == right[i]) ans++;
        }
        return ans;
    }
}