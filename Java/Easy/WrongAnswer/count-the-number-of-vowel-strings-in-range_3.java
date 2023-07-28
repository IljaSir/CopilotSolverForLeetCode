class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        
        int res = 0;
        for (int i = left; i <= right; i++) {
            String word = words[i];
            if (word.charAt(0) == 'a' && word.charAt(word.length() - 1) == 'u') {
                res++;
            }
        }
        return res;
    }
}