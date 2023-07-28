class Solution {
    public String robotWithString(String s) {
        
        char[] chars = s.toCharArray();
        int n = s.length();
        int i = 0, j = n - 1;
        StringBuilder sb = new StringBuilder();
        while (i <= j) {
            boolean left = false;
            for (int k = 0; i + k <= j; k++) {
                if (chars[i + k] < chars[j - k]) {
                    left = true;
                    break;
                } else if (chars[i + k] > chars[j - k]) {
                    left = false;
                    break;
                }
            }
            if (left) {
                sb.append(chars[i++]);
            } else {
                sb.append(chars[j--]);
            }
        }
        return sb.toString();
    }
}