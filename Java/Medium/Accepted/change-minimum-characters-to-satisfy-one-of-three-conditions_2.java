class Solution {
    public int minCharacters(String a, String b) {
        
        int[] countA = new int[26];
        int[] countB = new int[26];
        for (char c : a.toCharArray()) {
            countA[c - 'a']++;
        }
        for (char c : b.toCharArray()) {
            countB[c - 'a']++;
        }
        int n = a.length(), m = b.length();
        int res = n + m;
        for (int i = 0; i < 26; i++) {
            res = Math.min(res, n + m - countA[i] - countB[i]);
            if (i > 0) {
                countA[i] += countA[i - 1];
                countB[i] += countB[i - 1];
            }
            if (i < 25) {
                res = Math.min(res, n - countA[i] + countB[i]);
                res = Math.min(res, m - countB[i] + countA[i]);
            }
        }
        return res;
    }
}