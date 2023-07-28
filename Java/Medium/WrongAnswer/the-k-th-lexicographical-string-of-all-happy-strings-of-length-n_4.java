class Solution {
    public String getHappyString(int n, int k) {
        
        if (n == 1) {
            if (k > 3) {
                return "";
            }
            return String.valueOf((char) ('a' + k - 1));
        }
        int total = 1;
        for (int i = 1; i < n; i++) {
            total *= 2;
        }
        if (k > 3 * total) {
            return "";
        }
        int start = 1;
        for (int i = 1; i < n; i++) {
            start *= 2;
        }
        if (k <= total) {
            return String.valueOf((char) ('a')) + getHappyString(n - 1, k);
        }
        if (k <= 2 * total) {
            return String.valueOf((char) ('b')) + getHappyString(n - 1, k - total);
        }
        return String.valueOf((char) ('c')) + getHappyString(n - 1, k - 2 * total);
    }
}