class Solution {
    public int countTriples(int n) {
        
        int c = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                int x = a*a + b*b;
                int s = (int) Math.sqrt(x);
                if (s*s == x && s <= n) {
                    c++;
                }
            }
        }
        return c;
    }
}