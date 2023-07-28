class Solution {
    public String toHex(int num) {
        
        if (num == 0) return "0";
        char[] hex = "0123456789abcdef".toCharArray();
        String res = "";
        while (num != 0) {
            res = hex[num & 0xf] + res;
            num >>>= 4;
        }
        return res;
    }
}