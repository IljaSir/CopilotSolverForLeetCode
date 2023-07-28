class Solution {
    public int getLucky(String s, int k) {
        
        String s1 = "";
        for (char c : s.toCharArray()) {
            s1 += (c - 'a' + 1);
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            res = 0;
            for (char c : s1.toCharArray()) {
                res += c - '0';
            }
            s1 = String.valueOf(res);
        }
        return res;
    }
}