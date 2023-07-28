class Solution {
    public int minCharacters(String a, String b) {
        
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (char c : a.toCharArray()) {
            cnt1[c - 'a']++;
        }
        for (char c : b.toCharArray()) {
            cnt2[c - 'a']++;
        }
        int n = a.length();
        int m = b.length();
        int res = n + m;
        for (int i = 0; i < 25; i++) {
            res = Math.min(res, n + m - cnt1[i] - cnt2[i]);
            res = Math.min(res, n - cnt1[i] + cnt2[i]);
            res = Math.min(res, m - cnt2[i] + cnt1[i]);
        }
        return res;
    }
}