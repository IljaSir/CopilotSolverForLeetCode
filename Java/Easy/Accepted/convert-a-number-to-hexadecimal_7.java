class Solution {
    public String toHex(int num) {
        
        if (num == 0) {
            return "0";
        }
        char[] hex = new char[8];
        int index = 7;
        while (num != 0) {
            int digit = num & 15;
            if (digit < 10) {
                hex[index--] = (char) (digit + '0');
            } else {
                hex[index--] = (char) (digit - 10 + 'a');
            }
            num >>>= 4;
        }
        return new String(hex, index + 1, 8 - index - 1);
    }
}