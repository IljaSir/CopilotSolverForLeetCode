class Solution {
    public long minimumRemoval(int[] beans) {
        
        int n = beans.length;
        long sum = 0;
        for (int bean : beans) {
            sum += bean;
        }
        long avg = sum / n;
        long res = 0;
        for (int bean : beans) {
            if (bean > avg) {
                res += bean - avg;
            }
        }
        return res;
    }
}