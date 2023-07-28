class Solution {
    public String getHappyString(int n, int k) {
        
        int total = (int) Math.pow(2, n - 1);
        if (k > 3 * total) return "";
        int idx = k % total;
        if (idx == 0) idx = total;
        String str = "";
        for (int i = 0; i < n; i++) {
            int bit = (idx - 1) % 2;
            idx = (idx - 1) / 2;
            if (i == 0) {
                if (bit == 0) str += "a";
                else if (bit == 1) str += "b";
                else str += "c";
            } else {
                if (bit == 0) {
                    if (str.charAt(i - 1) == 'a') str += "b";
                    else str += "a";
                } else if (bit == 1) {
                    if (str.charAt(i - 1) == 'b') str += "c";
                    else str += "b";
                } else {
                    if (str.charAt(i - 1) == 'c') str += "a";
                    else str += "c";
                }
            }
        }
        return str;
    }
}