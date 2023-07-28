class Solution {
    public String[] divideString(String s, int k, char fill) {
        
        int n = s.length();
        int m = n / k;
        String[] result = new String[m];
        for (int i = 0; i < m; i++) {
            result[i] = s.substring(i * k, (i + 1) * k);
        }
        if (n % k != 0) {
            result[m] = s.substring(m * k) + (new String(new char[k - n % k]).replace("\0", String.valueOf(fill)));
        }
        return result;
    }
}