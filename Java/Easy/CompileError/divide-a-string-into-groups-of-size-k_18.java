class Solution {
    public String[] divideString(String s, int k, char fill) {
        
        int n = s.length();
        int num = n / k;
        num += n % k > 0 ? 1 : 0;
        String[] res = new String[num];
        int idx = 0;
        for (int i = 0; i < n; i += k) {
            int j = i + k;
            if (j > n)
                j = n;
            res[idx++] = s.substring(i, j);
        }
        if (n % k > 0) {
            int len = res[num - 1].length();
            for (int i = 0; i < k - len; i++) {
                res[num - 1] += fill;
            }
        }
        return res;
    }
}
    }
}