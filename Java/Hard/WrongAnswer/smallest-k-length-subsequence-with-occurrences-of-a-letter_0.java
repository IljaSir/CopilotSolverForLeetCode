class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        
        int n = s.length();
        int[] last = new int[26];
        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        int[] freq = new int[n];
        int[] prefix = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                prefix[i] = prefix[i - 1];
            }
            if (s.charAt(i) == letter) {
                prefix[i]++;
            }
        }
        for (int i = 0; i < n; i++) {
            freq[i] = prefix[i];
            if (i >= k) {
                freq[i] -= prefix[i - k];
            }
        }
        int minIndex = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == letter) {
                if (i + k - 1 < n && freq[i + k - 1] >= repetition) {
                    minIndex = i;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(letter);
        int remain = k - 1;
        int lastLetter = minIndex;
        int lastLetterFreq = 1;
        for (int i = minIndex + 1; i < n && remain > 0; i++) {
            if (s.charAt(i) == letter) {
                lastLetter = i;
                lastLetterFreq++;
            }
            if (last[s.charAt(i) - 'a'] >= lastLetter && lastLetterFreq + remain - 1 >= repetition) {
                sb.append(s.charAt(i));
                remain--;
            }
        }
        return sb.toString();
    }
}