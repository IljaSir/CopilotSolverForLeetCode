class Solution {
    public String addStrings(String num1, String num2) {
        
        int n1 = num1.length();
        int n2 = num2.length();
        int n = Math.max(n1, n2);
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int d1 = i < n1 ? num1.charAt(n1 - i - 1) - '0' : 0;
            int d2 = i < n2 ? num2.charAt(n2 - i - 1) - '0' : 0;
            int d = d1 + d2 + carry;
            carry = d / 10;
            sb.append(d % 10);
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}