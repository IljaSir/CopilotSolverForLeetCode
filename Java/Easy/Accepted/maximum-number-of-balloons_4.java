class Solution {
    public int maxNumberOfBalloons(String text) {
        
        int[] count = new int[26];
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }
        int result = Integer.MAX_VALUE;
        result = Math.min(result, count['b' - 'a']);
        result = Math.min(result, count['a' - 'a']);
        result = Math.min(result, count['l' - 'a'] / 2);
        result = Math.min(result, count['o' - 'a'] / 2);
        result = Math.min(result, count['n' - 'a']);
        return result;
    }
}