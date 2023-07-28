class Solution {
    public int countCharacters(String[] words, String chars) {
        
        int[] charCount = new int[26];
        for (char c : chars.toCharArray()) {
            charCount[c - 'a']++;
        }
        int ans = 0;
        for (String word : words) {
            int[] wordCount = new int[26];
            boolean good = true;
            for (char c : word.toCharArray()) {
                wordCount[c - 'a']++;
                if (wordCount[c - 'a'] > charCount[c - 'a']) {
                    good = false;
                    break;
                }
            }
            if (good) {
                ans += word.length();
            }
        }
        return ans;
    }
}