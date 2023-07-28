class Solution {
    public int countTriples(int n) {
        
        int count = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = a; b <= n; b++) {
                int c = a * a + b * b;
                if (c > n * n) {
                    break;
                }
                int sqrt = (int) Math.sqrt(c);
                if (sqrt * sqrt == c) {
                    count += 2;
                }
            }
        }
        return count;
    }
}