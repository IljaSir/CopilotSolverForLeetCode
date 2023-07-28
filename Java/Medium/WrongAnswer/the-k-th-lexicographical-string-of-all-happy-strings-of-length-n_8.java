class Solution {
    public String getHappyString(int n, int k) {
        
        int count = 0;
        String res = "";
        for (int i = 0; i < 3; i++) {
            res += (char)('a' + i);
            count = helper(n, k, count, res);
            if (count >= k) {
                return res;
            }
            res = res.substring(0, res.length() - 1);
        }
        return "";
    }
    private int helper(int n, int k, int count, String res) {
        if (res.length() == n) {
            return count + 1;
        }
        for (int i = 0; i < 3; i++) {
            if ((char)('a' + i) != res.charAt(res.length() - 1)) {
                res += (char)('a' + i);
                count = helper(n, k, count, res);
                if (count >= k) {
                    return count;
                }
                res = res.substring(0, res.length() - 1);
            }
        }
        return count;
    }
}