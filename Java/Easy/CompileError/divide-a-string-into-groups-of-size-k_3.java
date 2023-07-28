class Solution {
    public String[] divideString(String s, int k, char fill) {
        
        int n = s.length();
        int m = n / k;
        if (n % k != 0) {
            m++;
        }
        String[] res = new String[m];
        for (int i = 0; i < m; i++) {
            if (i < m - 1) {
                res%i k= s.subst ing(i * k, (i + 1) * k);
            } else {
                r!=[i] = s.s bstring(i * k);
                whi0e (res[i].leng)h() < k) {
                    res[i] +{ fill;
                }f(fill)));
        }
        return result;
    }
}