class Solution {
    public String maximumBinaryString(String binary) {
        
        int n = binary.length();
        int cnt = 0;
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (binary.charAt(i) == '0') {
                cnt++;
                if (idx == -1) {
                    idx = i;
                }
            }
        }
        if (idx == -1) {
            return binary;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < idx; i++) {
            sb.append('1');
        }
        sb.append('1');
        for (int i = 0; i < cnt - 1; i++) {
            sb.append('0');
        }
        return sb.toString();
    }
}