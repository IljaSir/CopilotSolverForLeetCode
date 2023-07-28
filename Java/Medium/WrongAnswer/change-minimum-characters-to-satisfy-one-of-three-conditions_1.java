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
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            int cur = 0;
            for (int j = 0; j < 26; j++) {
                if (j <= i) {
                    cur += countA[j];
                } else {
                    cur += countB[j];
                }
            }
            res = Math.min(res, cur);
        }
        for (int i = 0; i < 26; i++) {
            int cur = 0;
            for (int j = 0; j < 26; j++) {
                if (j <= i) {
                    cur += countB[j];
                } else {
                    cur += countA[j];
                }
            }
            res = Math.min(res, cur);
        }
        int[] preA = new int[26];
        int[] preB = new int[26];
        preA[0] = countA[0];
        preB[0] = countB[0];
        for (int i = 1; i < 26; i++) {
            preA[i] = preA[i - 1] + countA[i];
            preB[i] = preB[i - 1] + countB[i];
        }
        for (int i = 0; i < 25; i++) {
            res = Math.min(res, a.length() + b.length() - preA[i] - preB[25] + preB[i]);
            res = Math.min(res, a.length() + b.length() - preB[i] - preA[25] + preA[i]);
        }
        return res;
    }
}