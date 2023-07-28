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
        StringBuilder ans = new StringBuilder();
        while (i < n) {
            if (n - i == 4) {
                ans.append(sb.substring(i, i + 2));
                ans.append('-');
                ans.append(sb.substring(i + 2, i + 4));
                break;
            } else if (n - i == 2) {
                ans.append(sb.substring(i, i + 2));
                break;
            } else if (n - i == 3) {
                ans.append(sb.substring(i, i + 3));
                break;
            } else {
                ans.append(sb.substring(i, i + 3));
                ans.append('-');
                i += 3;
            }
        }
        return ans.toString();
    }
}