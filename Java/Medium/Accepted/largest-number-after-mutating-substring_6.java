class Solution {
    public String maximumNumber(String num, int[] change) {
        
        char[] chars = num.toCharArray();
        boolean start = false;
        for (int i = 0; i < chars.length; i++) {
            int c = chars[i] - '0';
            if (change[c] > c) {
                chars[i] = (char) (change[c] + '0');
                start = true;
            } else if (change[c] < c) {
                if (start) {
                    break;
                }
            }
        }
        return new String(chars);
    }
}