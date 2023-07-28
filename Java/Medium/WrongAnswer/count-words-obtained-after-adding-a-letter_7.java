class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        
        int total = 0;
        for (String word : targetWords) {
            for (String start : startWords) {
                if (canConvert(start, word)) {
                    total++;
                    break;
                }
            }
        }
        return total;
    }

    private boolean canConvert(String start, String target) {
        if (target.length() < start.length()) {
            return false;
        }

        int[] startFreq = new int[26];
        int[] targetFreq = new int[26];
        for (int i = 0; i < start.length(); i++) {
            startFreq[start.charAt(i) - 'a']++;
        }

        for (int i = 0; i < target.length(); i++) {
            targetFreq[target.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (targetFreq[i] < startFreq[i]) {
                return false;
            }
        }

        return true;
    }
}