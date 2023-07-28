class Solution {
    public String removeKdigits(String num, int k) {
        
        if (num.length() == k) return "0";
        int i = 0;
        while (k > 0) {
            if (i == num.length() - 1 || num.charAt(i) > num.charAt(i + 1)) {
                num = num.substring(0, i) + num.substring(i + 1);
                k--;
                if (i > 0) i--;
            } else {
                i++;
            }
        }
        while (num.length() > 0 && num.charAt(0) == '0') {
            num = num.substring(1);
        }
        return num.length() == 0 ? "0" : num;
    }
}