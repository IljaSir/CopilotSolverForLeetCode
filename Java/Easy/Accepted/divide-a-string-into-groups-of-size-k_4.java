class Solution {
    public String[] divideString(String s, int k, char fill) {
        
        int n = s.length();
        String[] res = new String[(n + k - 1) / k];
        for (int i = 0; i < n; i++) {
            int idx = i / k;
            if (res[idx] == null) {
                res[idx] = "";
            }
            res[idx] += s.charAt(i);
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] == null) {
                res[i] = "";
            }
            while (res[i].length() < k) {
                res[i] += fill;
            }
        }
        return res;
    }
}