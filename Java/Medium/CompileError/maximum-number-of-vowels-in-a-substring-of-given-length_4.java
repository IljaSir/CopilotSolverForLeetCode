class Solution {
    public int maxVowels(String s, int k) {
        
        int max = 0;
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < k) {
                if (isVowel(s.charAt(i))) {
                    cur++;
                }
            } else {
                if (isVowel(s.charAt(i))) {
                    cur++;
                }
                if (isVowel(s.charAt(i - k))) {
                    cur--;
                }
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}