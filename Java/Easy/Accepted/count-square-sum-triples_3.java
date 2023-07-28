class Solution {
    public int countTriples(int n) {
        
        int count = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = a; b <= n; b++) {
                int c = a * a + b * b;
                int c1 = (int) Math.sqrt(c);
                if (c1 * c1 == c && c1 <= n) {
                    count += 2;
                }
            }
        }
        return count;
    }
}