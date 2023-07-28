class Solution {
    public int maxNumberOfBalloons(String text) {
        
        int[] count = new int[26];
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }
        int result = Integer.MAX_VALUE;
        for (char c : "balloon".toCharArray()) {
            if (c == 'l' || c == 'o') {
                result = Math.min(result, count[c - 'a'] / 2);
            } else {
                result = Math.min(result, count[c - 'a']);
            }
        }
        return result;
    }
}