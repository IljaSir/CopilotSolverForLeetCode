class Solution {
    public String addStrings(String num1, String num2) {
        
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += num2.charAt(j--) - '0';
            if (i >= 0) sum += num1.charAt(i--) - '0';
            sb.append(sum % 10);
            carry = sum / 10;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}