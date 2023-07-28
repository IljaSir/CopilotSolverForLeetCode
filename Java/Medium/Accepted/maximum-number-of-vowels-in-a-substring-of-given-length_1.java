class Solution {
    public int maxVowels(String s, int k) {
        
        int max = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
            if (i >= k && (s.charAt(i - k) == 'a' || s.charAt(i - k) == 'e' || s.charAt(i - k) == 'i' || s.charAt(i - k) == 'o' || s.charAt(i - k) == 'u')) {
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}