class Solution {
    public String fractionAddition(String expression) {
        
        String[] fractions = expression.split("(?=[-+])");
        int[] res = new int[2];
        res[0] = 0;
        res[1] = 1;
        for (String fraction : fractions) {
            int[] frac = new int[2];
            frac[0] = Integer.parseInt(fraction.split("/")[0]);
            frac[1] = Integer.parseInt(fraction.split("/")[1]);
            res = add(res, frac);
        }
        return res[0] + "/" + res[1];
    }

    public int[] add(int[] a, int[] b) {
        int[] res = new int[2];
        res[1] = a[1] * b[1];
        res[0] = a[0] * b[1] + b[0] * a[1];
        int gcd = gcd(res[0], res[1]);
        res[0] /= gcd;
        res[1] /= gcd;
        return res;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}