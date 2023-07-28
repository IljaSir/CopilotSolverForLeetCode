class Solution {
    public int uniqueLetterString(String s) {
        
        int n = s.length();
        int[] last = new int[26];
        int[] pre = new int[26];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int x = s.charAt(i) - 'A';
            ans += (i + 1 - pre[x]) * (pre[x] - last[x]);
            last[x] = pre[x];
            pre[x] = i + 1;
        }
        for (int i = 0; i < 26; i++) {
            ans += (n + 1 - pre[i]) * (pre[i] - last[i]);
        }
        return ans;
    }
}