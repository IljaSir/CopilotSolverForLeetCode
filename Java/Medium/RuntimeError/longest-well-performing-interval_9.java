class Solution {
    public int longestWPI(int[] hours) {
        
        int res = 0;
        int sum = 0;
        int[] map = new int[hours.length];
        for (int i = 0; i < hours.length; i++) {
            sum += hours[i] > 8 ? 1 : -1;
            if (sum > 0) {
                res = i + 1;
            } else {
                if (map[-sum] != 0) {
                    res = Math.max(res, i - map[-sum] + 1);
                } else {
                    map[-sum] = i + 1;
                }
            }
        }
        return res;
    }
}