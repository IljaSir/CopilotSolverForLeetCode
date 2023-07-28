class Solution {
    public String digitSum(String s, int k) {
        
        while (s.length() > k) {
            int i = 0;
            int j = k;
            String temp = "";
            while (j <= s.length()) {
                int sum = 0;
                for (int m = i; m < j; m++) {
                    sum += Character.getNumericValue(s.charAt(m));
                }
                temp += String.valueOf(sum);
                i += k;
                j += k;
            }
            if (s.length() % k != 0) {
                int sum = 0;
                for (int m = i; m < s.length(); m++) {
                    sum += Character.getNumericValue(s.charAt(m));
                }
                temp += String.valueOf(sum);
            }
            s = temp;
        }
        return s;
    }
}