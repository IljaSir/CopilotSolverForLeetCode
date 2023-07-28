class Solution {
    public int minCharacters(String a, String b) {
        
        int[] freqA = new int[26];
        int[] freqB = new int[26];
        for (char c : a.toCharArray()) {
            freqA[c - 'a']++;
        }
        for (char c : b.toCharArray()) {
            freqB[c - 'a']++;
        }
        int res = Integer.MAX_VALUE;
        // condition 1
        for (int i = 1; i < 26; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                count += freqA[j] + freqB[j];
            }
            res = Math.min(res, count);
        }
        // condition 2
        for (int i = 1; i < 26; i++) {
            int count = 0;
            for (int j = i; j < 26; j++) {
                count += freqA[j] + freqB[j];
            }
            res = Math.min(res, count);
        }
        // condition 3
        int countA = 0, countB = 0;
        for (int i = 0; i < 26; i++) {
            countA += freqA[i];
            countB += freqB[i];
        }
        res = Math.min(res, a.length() - countA + b.length() - countB);
        return res;
    }
}