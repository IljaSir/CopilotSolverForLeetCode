class Solution {
    public String digitSum(String s, int k) {
        
        int n = s.length();
        String res = s;
        while (res.length() > k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < res.length(); i += k) {
                int sum = 0;
                for (int j = i; j < i + k && j < res.length(); j++) {
                    sum += res.charAt(j) - '0';
                }
                sb.append(sum);
            }
            res = sb.toString();
        }
        return res;
    }
}