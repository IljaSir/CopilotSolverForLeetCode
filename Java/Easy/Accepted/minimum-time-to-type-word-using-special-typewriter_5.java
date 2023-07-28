class Solution {
    public int minTimeToType(String word) {
        
        int n = word.length();
        int ans = 0;
        char c = 'a';
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            int d = Math.abs(ch - c);
            ans += Math.min(d, 26 - d);
            ans++;
            c = ch;
        }
        return ans;
    }
}