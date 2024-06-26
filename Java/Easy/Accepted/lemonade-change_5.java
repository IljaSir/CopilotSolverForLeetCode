class Solution {
    public boolean lemonadeChange(int[] bills) {
        
        int c5 = 0, c10 = 0;
        for (int b : bills) {
            if (b == 5) {
                c5++;
            } else if (b == 10) {
                if (c5 == 0) {
                    return false;
                }
                c10++;
                c5--;
            } else {
                if (c5 > 0 && c10 > 0) {
                    c5--;
                    c10--;
                } else if (c5 >= 3) {
                    c5 -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}