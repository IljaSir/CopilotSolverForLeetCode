class Solution {
    public int compress(char[] chars) {
        
        int i = 0;
        int j = 0;
        int n = chars.length;
        while (i < n) {
            int count = 0;
            char c = chars[i];
            while (i < n && chars[i] == c) {
                i++;
                count++;
            }
            chars[j++] = c;
            if (count > 1) {
                String s = String.valueOf(count);
                for (char ch : s.toCharArray()) {
                    chars[j++] = ch;
                }
            }
        }
        return j;
    }
}