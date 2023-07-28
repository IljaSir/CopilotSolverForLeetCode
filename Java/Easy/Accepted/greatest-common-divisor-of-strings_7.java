class Solution {
    public String gcdOfStrings(String str1, String str2) {
        
        int gcd = gcd(str1.length(), str2.length());
        String candidate = str1.substring(0, gcd);
        if (!str1.replace(candidate, "").equals("") || !str2.replace(candidate, "").equals("")) {
            return "";
        }
        return candidate;
    }
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}