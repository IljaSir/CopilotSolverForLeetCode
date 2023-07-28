class Solution {
    public int minCharacters(String a, String b) {
        
        int[] cntA = new int[26];
        int[] cntB = new int[26];
        int n = a.length(), m = b.length();
        for (char c: a.toCharArray()) cntA[c - 'a']++;
        for (char c: b.toCharArray()) cntB[c - 'a']++;
        int ans = n + m;
        for (int i = 0; i < 26; i++) {
            int cur = n + m - cntA[i] - cntB[i];
            if (i > 0) {
                cur += cntA[i - 1] + cntB[i - 1];
            }
            ans = Math.min(ans, cur);
        }
        for (int i = 0; i < 26; i++) {
            int cur = n + m - cntA[i] - cntB[i];
            if (i < 25) {
                cur += cntA[i + 1] + cntB[i + 1];
            }
            ans = Math.min(ans, cur);
        }
        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            cnt += cntA[i];
            ans = Math.min(ans, n - cnt);
        }
        cnt = 0;
        for (int i = 0; i < 26; i++) {
            cnt += cntB[i];
            ans = Math.min(ans, m - cnt);
        }
        return ans;
    }
}