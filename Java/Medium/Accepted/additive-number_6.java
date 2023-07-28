class Solution {
    public boolean isAdditiveNumber(String num) {
        
        for (int i = 1; i < num.length(); i++) {
            for (int j = i + 1; j < num.length(); j++) {
                String s1 = num.substring(0, i);
                String s2 = num.substring(i, j);
                if (isValid(s1, s2, num.substring(j))) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isValid(String s1, String s2, String s) {
        if (s1.length() > 1 && s1.startsWith("0")) {
            return false;
        }
        if (s2.length() > 1 && s2.startsWith("0")) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }
        String sum = add(s1, s2);
        if (s.startsWith(sum)) {
            return isValid(s2, sum, s.substring(sum.length()));
        }
        return false;
    }
    
    public String add(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        while (i >= 0 || j >= 0) {
            int c1 = i >= 0 ? s1.charAt(i) - '0' : 0;
            int c2 = j >= 0 ? s2.charAt(j) - '0' : 0;
            int sum = c1 + c2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}