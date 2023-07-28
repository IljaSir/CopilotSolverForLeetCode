class Solution {
    public String gcdOfStrings(String str1, String str2) {
        
        int gcd = gcd(str1.length(), str2.length());
        String str = str1.substring(0, gcd);
        if (check(str1, str) && check(str2, str)) {
            return str;
        }
        return "";
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private boolean check(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        if (m % n != 0) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            if (str1.charAt(i) != str2.charAt(i % n)) {
                return false;
            }
        }
        return true;
    }
}