class Solution {
    public String maximumBinaryString(String binary) {
        
        int n = binary.length();
        int firstZero = -1;
        int lastOne = -1;
        for (int i = 0; i < n; i++) {
            if (binary.charAt(i) == '0') {
                firstZero = i;
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                lastOne = i;
                break;
            }
        }
        if (firstZero == -1) {
            return binary;
        }
        int cnt = 0;
        for (int i = firstZero; i <= lastOne; i++) {
            if (binary.charAt(i) == '0') {
                cnt++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < firstZero; i++) {
            sb.append('1');
        }
        sb.append('1');
        for (int i = 0; i < cnt - 1; i++) {
            sb.append('0');
        }
        for (int i = lastOne + 1; i < n; i++) {
            sb.append('1');
        }
        return sb.toString();
    }
}