class Solution {
    public String reformatNumber(String number) {
        
        StringBuilder sb = new StringBuilder();
        for (char c : number.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        int len = sb.length();
        int i = 0;
        while (i < len - 4) {
            sb.insert(i + 3, '-');
            len++;
            i += 4;
        }
        if (len - i == 4) {
            sb.insert(i + 2, '-');
        }
        return sb.toString();
    }
}