class Solution {
    public String maximumBinaryString(String binary) {
        
        int n = binary.length();
        int count = 0;
        int first = 0;
        for (int i = 0; i < n; i++) {
            if (binary.charAt(i) == '0') {
                count++;
            }
            if (count == 1 && binary.charAt(i) == '1') {
                first = i;
            }
        }
        if (count == 0) {
            return binary;
        }
        char[] ans = new char[n];
        Arrays.fill(ans, '1');
        ans[n - count] = '0';
        return String.valueOf(ans);
    }
}