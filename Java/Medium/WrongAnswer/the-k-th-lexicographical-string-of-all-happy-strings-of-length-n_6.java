class Solution {
    public String getHappyString(int n, int k) {
        
        return getHappyString(n, k, "a");
    }
    
    public String getHappyString(int n, int k, String s) {
        if (n == 0) {
            return s;
        }
        if (k > 3 * Math.pow(2, n - 1)) {
            return "";
        }
        char[] letters = {'a', 'b', 'c'};
        for (char c : letters) {
            if (c != s.charAt(s.length() - 1)) {
                String str = getHappyString(n - 1, k, s + c);
                if (!str.isEmpty()) {
                    return str;
                }
                k -= Math.pow(2, n - 1);
            }
        }
        return "";
    }
}