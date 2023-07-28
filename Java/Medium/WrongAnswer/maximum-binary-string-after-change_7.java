class Solution {
    public String maximumBinaryString(String binary) {
        
        int n = binary.length();
        int ones = 0;
        boolean hasZero = false;
        for (char c : binary.toCharArray()) {
            if (c == '1') ones++;
            else hasZero = true;
        }
        if (!hasZero) return binary;
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        for (int i = 1; i < n - ones; ++i) sb.append("0");
        for (int i = 0; i < ones; ++i) sb.append("1");
        return sb.toString();
    }
}