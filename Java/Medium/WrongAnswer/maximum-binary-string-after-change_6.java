class Solution {
    public String maximumBinaryString(String binary) {
        
        int count = 0;
        int maxCount = 0;
        int firstOne = -1;
        int lastZero = -1;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                count++;
                lastZero = i;
            } else {
                count = 0;
                if (firstOne == -1) {
                    firstOne = i;
                }
            }
            maxCount = Math.max(count, maxCount);
        }
        if (maxCount == 0) {
            return binary;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < firstOne; i++) {
            sb.append('1');
        }
        sb.append('0');
        for (int i = 0; i < maxCount - 1; i++) {
            sb.append('1');
        }
        for (int i = lastZero + 1; i < binary.length(); i++) {
            sb.append('1');
        }
        return sb.toString();
    }
}