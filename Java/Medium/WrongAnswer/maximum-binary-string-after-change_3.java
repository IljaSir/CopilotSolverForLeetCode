class Solution {
    public String maximumBinaryString(String binary) {
        
        int n = binary.length();
        int count = 0;
        int first = 0;
        for (int i = 0; i < n; i++) {
            if (binary.charAt(i) == '0') {
                count++;
                if (first == 0) {
                    first = i;
                }
            }
        }
        if (count == 0) {
            return binary;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < first; i++) {
            sb.append('1');
        }
        sb.append('0');
        for (int i = 0; i < count - 1; i++) {
            sb.append('1');
        }
        for (int i = first + count; i < n; i++) {
            sb.append('0');
        }
        return sb.toString();
    }
}