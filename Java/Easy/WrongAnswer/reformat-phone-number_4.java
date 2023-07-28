class Solution {
    public String reformatNumber(String number) {
        
        StringBuilder sb = new StringBuilder();
        for (char c : number.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        int n = sb.length();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0 && (i % 3 == 0)) {
                if (n - i == 4) {
                    res.append('-');
                } else {
                    res.append('-');
                }
            }
            res.append(sb.charAt(i));
        }
        return res.toString();
    }
}