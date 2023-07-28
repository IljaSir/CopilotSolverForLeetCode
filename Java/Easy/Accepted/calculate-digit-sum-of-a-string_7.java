class Solution {
    public String digitSum(String s, int k) {
        
        if (s.length() <= k) {
            return s;
        }
        int i = 0;
        int j = k;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        while (j <= s.length()) {
            //System.out.println("i: " + i + " j: " + j);
            for (int m = i; m < j; m++) {
                sum += Character.getNumericValue(s.charAt(m));
            }
            sb.append(sum);
            i = j;
            j += k;
            sum = 0;
        }
        if (i < s.length()) {
            for (int m = i; m < s.length(); m++) {
                sum += Character.getNumericValue(s.charAt(m));
            }
            sb.append(sum);
        }
        //System.out.println(sb.toString());
        return digitSum(sb.toString(), k);
    }
    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }
        String result = digitSum(num, k);
        int i = 0;
        while (i < result.length() && result.charAt(i) == '0') {
            i++;
        }
        if (i == result.length()) {
            return "0";
        }
        return result.substring(i);
    }
}