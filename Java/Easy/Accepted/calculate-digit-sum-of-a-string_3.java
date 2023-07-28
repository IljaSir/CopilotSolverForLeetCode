class Solution {
    public String digitSum(String s, int k) {
        
        while (s.length() > k) {
            int i = 0;
            StringBuilder sb = new StringBuilder();
            while (i < s.length()) {
                int sum = 0;
                for (int j = 0; j < k; j++) {
                    if (i >= s.length()) {
                        break;
                    }
                    sum += s.charAt(i) - '0';
                    i++;
                }
                sb.append(sum);
            }
            s = sb.toString();
        }
        return s;
    }
}