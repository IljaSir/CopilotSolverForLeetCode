class Solution {
    public int maxNumberOfBalloons(String text) {
        
        int[] count = new int[26];
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }
        int min = count[0];
        min = Math.min(min, count[1]);
        min = Math.min(min, count[11] / 2);
        min = Math.min(min, count[14] / 2);
        min = Math.min(min, count[13]);
        return min;
    }
}