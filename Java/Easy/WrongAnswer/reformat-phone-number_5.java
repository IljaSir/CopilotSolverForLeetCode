class Solution {
    public String reformatNumber(String number) {
        
        StringBuilder sb = new StringBuilder();
        for (char c : number.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        int n = sb.length();
        int i = 0;
        StringBuilder res = new StringBuilder();
        while (i < n) {
            if (i + 4 == n) {
                res.append(sb.substring(i, i + 2));
                res.append('-');
                res.append(sb.substring(i + 2, i + 4));
                break;
            } else if (i + 2 == n) {
                res.append(sb.substring(i, i + 2));
                break;
            } else {
                res.append(sb.substring(i, i + 3));
                res.append('-');
                i += 3;
            }
        }
        return res.toString();
    }
}