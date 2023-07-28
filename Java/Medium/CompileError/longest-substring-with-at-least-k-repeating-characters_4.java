class Solution {
    public int longestSubstring(String s, int k) {
        
        int n = s.length();
        if (n < k) return 0;
        int[] counts = new int[26];
        for (int i = 0; i < n; i++) {
            counts[s.charAt(i) - 'a']++;
        }
        boolean[] valid = new boolean[26];
        Arrays.fill(valid, true);
        int ans = 0;
        f
        return ans;
    }
}