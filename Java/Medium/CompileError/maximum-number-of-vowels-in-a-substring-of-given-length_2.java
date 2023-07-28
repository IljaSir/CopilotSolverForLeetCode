class Solution {
    public int maxVowels(String s, int k) {
        
        int max = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i >= k && isVowel(s.charAt(i - k))) {
                count--;
            }
            if (isVowel(s.charAt(i))) {
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}