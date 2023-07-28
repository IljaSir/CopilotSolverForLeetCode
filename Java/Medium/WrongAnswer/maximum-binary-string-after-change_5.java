class Solution {
    public String maximumBinaryString(String binary) {
        
        int n = binary.length();
        char[] chars = binary.toCharArray();
        int firstZero = -1;
        int lastZero = -1;
        for (int i = 0; i < n; i++) {
            if (chars[i] == '0') {
                if (firstZero == -1) {
                    firstZero = i;
                }
                lastZero = i;
            }
        }
        if (firstZero == -1) {
            return binary;
        }
        for (int i = firstZero; i <= lastZero; i++) {
            chars[i] = '1';
        }
        if (firstZero > 0) {
            chars[firstZero - 1] = '0';
        }
        return new String(chars);
    }
}