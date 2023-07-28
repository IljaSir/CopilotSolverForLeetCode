class Solution {
    public String toHex(int num) {
        
        if (num == 0) return "0";
        char[] hex = "0123456789abcdef".toCharArray();
        String result = "";
        while (num != 0) {
            result = hex[(num & 15)] + result;
            num >>>= 4;
        }
        return result;
    }
}