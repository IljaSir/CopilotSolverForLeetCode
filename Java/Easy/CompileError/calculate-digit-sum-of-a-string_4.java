class Solution {
    public String digitSum(String s, int k) {
        
        int n = s.length();
        if (n == 1) {
            return s;
        }
        if (n <= k) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += s.charAt(i) - '0';
            }
            return Integer.toString(sum);
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < n) {
            int j = i + k;
            int sum = 0;
            while (i < j && i < n) {
                sum += s.charAt(i) - '0';
                i++;
            }
            sb.append(Integer.toString(sum));
        }
        return digitSum(sb.toString(), k);
    }
    public String truncate(String s, int k) {
        int n = s.length();
        if (n <= k) {
            return s;
        }
        return s.substring(0, k);
    }
    public String truncateAndSum(String s, int k) {
        int n = s.length();
        if (n <= k) {
            return s;
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += s.charAt(i) - '0';
        }
        return Integer.toString(sum);
    }
    public String truncateAndSum2(String s, int k) {
        int n = s.length();
        if (n <= k) {
            return s;
        }
        int sum = 0;
        for (int i = n - k; i < n; i++) {
            sum += s.charAt(i) - '0';
        }
        return Integer.toString(sum);
    }
    public String truncateAndSum3(String s, int k) {
        int n = s.length();
        if (n <= k) {
            return s;
        }
        int sum = 0;
        for (int i = 0; i < n - k; i++) {
            sum += s.charAt(i) - '0';
        }
        return Integer.toString(sum);
    }
    public String truncateAndSum4(String s, int k) {
        int n = s.length();
        if (n <= k) {
            return s;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
    }
}