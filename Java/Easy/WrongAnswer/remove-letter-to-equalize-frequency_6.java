class Solution {
    public boolean equalFrequency(String word) {
        
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        int[] freqFreq = new int[word.length() + 1];
        for (int f : freq) {
            if (f == 0) {
                continue;
            }
            freqFreq[f]++;
        }
        int count = 0;
        for (int f : freqFreq) {
            if (f > 0) {
                count++;
            }
        }
        if (count == 1) {
            return true;
        }
        if (count == 2) {
            if (freqFreq[1] == 1) {
                return true;
            }
            for (int i = 2; i < freqFreq.length; i++) {
                if (freqFreq[i] == 1 && freqFreq[i - 1] == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}