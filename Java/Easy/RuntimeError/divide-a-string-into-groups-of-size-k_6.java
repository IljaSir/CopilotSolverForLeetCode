class Solution {
    public String[] divideString(String s, int k, char fill) {
        
        int n = s.length();
        int m = n / k;
        if (n % k != 0) {
            m++;
        }
        String[] result = new String[m];
        int i = 0;
        int j = 0;
        while (i < n) {
            result[j] = s.substring(i, i + k);
            i += k;
            j++;
        }
        if (n % k != 0) {
            result[j - 1] = result[j - 1] + fill + fill;
        }
        return result;
    }
}