class Solution {
    public int countTriples(int n) {
        
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int c = i * i + j * j;
                int k = (int) Math.sqrt(c);
                if (k <= n && k * k == c) {
                    res += 2;
                }
            }
        }
        return res;
    }
}