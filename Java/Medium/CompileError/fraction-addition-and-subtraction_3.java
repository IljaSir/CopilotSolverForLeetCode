class Solution {
    public String fractionAddition(String expression) {
        
        int a = 0, b = 1;
        String[] s = expression.split("(?=[-+])");
        for (String t : s) {
            String[] u = t.split("/");
            int c = Integer.valueOf(u[0]), d = Integer.valueOf(u[1]);
            a = a * d + b * c;
            b *= d;
            int g = gcd(a, b);
            a /= g;
            b /= g;
        }
        return a + "/" + b;
    }
}