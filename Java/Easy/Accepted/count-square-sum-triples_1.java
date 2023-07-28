class Solution {
    public int countTriples(int n) {
        
        int count = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                int c = a * a + b * b;
                int cSqrt = (int) Math.sqrt(c);
                if (cSqrt * cSqrt == c && cSqrt <= n) {
                    count++;
                }
            }
        }
        return count;
    }
}