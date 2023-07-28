class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        
        int count = 0;

        for (String target : targetWords) {
            for (String start : startWords) {
                if (start.length() < target.length() && isPossible(start, target)) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    private boolean isPossible(String start, String target) {
        int[] freq = new int[26];
        for (char c : start.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : target.toCharArray()) {
            if (freq[c - 'a'] == 0) {
                return false;
            }
            freq[c - 'a']--;
        }

        return true;
    }
}