class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        
        int[] wordsFreq = new int[words.length];
        int[] queriesFreq = new int[queries.length];
        for (int i = 0; i < words.length; i++) {
            wordsFreq[i] = getFreq(words[i]);
        }
        for (int i = 0; i < queries.length; i++) {
            queriesFreq[i] = getFreq(queries[i]);
        }
        int[] count = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (queriesFreq[i] < wordsFreq[j]) {
                    count[i]++;
                }
            }
        }
        return count;
    }
    private int getFreq(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                return freq[i];
            }
        }
        return 0;
    }
}