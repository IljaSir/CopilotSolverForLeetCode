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
                res += bean - avg - 1;
            } else if (rem > 0) {
                res += avg - bean;
                rem--;
            } else {
                res += avg - bean;
            }
        }
        return res;
    }
}