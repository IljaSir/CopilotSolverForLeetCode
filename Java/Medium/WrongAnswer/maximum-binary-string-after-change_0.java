class Solution {
    public String maximumBinaryString(String binary) {
        
        int count = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                count++;
            }
        }
        if (count == 0) {
            return binary;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < binary.length(); i++) {
            if (i == 0) {
                sb.append("1");
            } else if (i == binary.length() - count) {
                for (int j = 0; j < count; j++) {
                    sb.append("1");
                }
            } else {
                sb.append("0");
            }
        }
        return sb.toString();
    }
}