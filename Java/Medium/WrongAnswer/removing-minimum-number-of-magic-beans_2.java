class Solution {
    public long minimumRemoval(int[] beans) {
        
        long sum = 0;
        for (int bean : beans) {
            sum += bean;
        }
        long avg = sum / beans.length;
        long rem = sum % beans.length;
        long res = 0;
        for (int bean : beans) {
            if (bean > avg) {
                res += bean - avg;
            }
            if (bean > avg + 1) {
                res += bean - avg - 1;
            }
        }
        return res;
    }
}