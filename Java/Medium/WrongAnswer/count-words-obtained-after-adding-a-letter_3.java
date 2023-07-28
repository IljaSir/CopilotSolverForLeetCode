class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        
        int count = 0;
        for (String target : targetWords) {
            for (String start : startWords) {
                if (wordCount(start, target)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private boolean wordCount(String start, String target) {
        if (target.length() < start.length()) return false;
        int[] freq = new int[26];
        for (char c : start.toCharArray()) freq[c - 'a']++;
        for (char c : target.toCharArray()) freq[c - 'a']--;
        for (int i : freq) {
            if (i > 0) return false;
        }
        return true;
    }
}