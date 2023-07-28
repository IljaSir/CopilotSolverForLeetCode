class Solution {
    public int countTriples(int n) {
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int k = i * i + j * j;
                double sq = Math.sqrt(k);
                if (sq == (int) sq && sq <= n) {
                    count++;
                }
            }
        }
        return count * 2;
    }
}