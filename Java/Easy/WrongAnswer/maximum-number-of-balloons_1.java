class Solution {
    public int maxNumberOfBalloons(String text) {
        
        int[] count = new int[26];
        for (int i = 0; i < text.length(); i++) {
            count[text.charAt(i) - 'a']++;
        }
        int res = Integer.MAX_VALUE;
        res = Math.min(res, count[1]);
        res = Math.min(res, count[0]);
        res = Math.min(res, count[11]);
        res = Math.min(res, count[14] / 2);
        res = Math.min(res, count[13] / 2);
        return res;
    }
}