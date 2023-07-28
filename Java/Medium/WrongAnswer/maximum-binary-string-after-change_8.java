class Solution {
    public String maximumBinaryString(String binary) {
        
        if (binary.indexOf("0") == -1) {
            return binary;
        }
        int idx = binary.indexOf("0");
        int count = 0;
        for (int i = idx; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                count++;
            }
        }
        char[] chars = new char[binary.length()];
        Arrays.fill(chars, '1');
        chars[0] = '0';
        chars[binary.length() - count] = '0';
        return new String(chars);
    }
}