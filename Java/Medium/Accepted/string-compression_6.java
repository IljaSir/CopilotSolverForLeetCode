class Solution {
    public int compress(char[] chars) {
        
        int n = chars.length;
        int count = 1;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && chars[i] == chars[i + 1]) {
                count++;
            } else {
                chars[idx++] = chars[i];
                if (count > 1) {
                    String cnt = String.valueOf(count);
                    for (char c : cnt.toCharArray()) {
                        chars[idx++] = c;
                    }
                }
                count = 1;
            }
        }
        return idx;
    }
}