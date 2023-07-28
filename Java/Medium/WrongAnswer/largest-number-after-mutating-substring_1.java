class Solution {
    public String maximumNumber(String num, int[] change) {
        
        char[] chars = num.toCharArray();
        int i = 0;
        while (i < chars.length) {
            int digit = chars[i] - '0';
            if (digit < change[digit]) {
                while (i < chars.length && chars[i] - '0' <= change[chars[i] - '0']) {
                    chars[i] = (char) (change[chars[i] - '0'] + '0');
                    i++;
                }
            } else {
                i++;
            }
        }
        return new String(chars);
    }
}