class Solution {
    public int countTriples(int n) {
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int c = i * i + j * j;
                int k = (int) Math.sqrt(c);
                if (k * k == c && k <= n) {
                    count += 2;
                }
            }
        }
        return count;
    }
}