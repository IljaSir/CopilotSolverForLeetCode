class Solution {
    public int minCharacters(String a, String b) {
        
        int[] cntA = new int[26];
        int[] cntB = new int[26];
        for (char c : a.toCharArray()) cntA[c - 'a']++;
        for (char c : b.toCharArray()) cntB[c - 'a']++;
        int n = a.length(), m = b.length();
        int res = n + m;
        // condition 1
        for (int i = 1; i < 26; i++) {
            res = Math.min(res, n - cntA[i] + m - cntB[i - 1]);
        }
        // condition 2
        for (int i = 1; i < 26; i++) {
            res = Math.min(res, n - cntA[i - 1] + m - cntB[i]);
        }
        // condition 3
        int maxA = 0, maxB = 0;
        for (int i = 0; i < 26; i++) {
            maxA = Math.max(maxA, cntA[i]);
            maxB = Math.max(maxB, cntB[i]);
        }
        res = Math.min(res, n + m - maxA - maxB);
        return res;
    }
}