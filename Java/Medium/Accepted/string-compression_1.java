class Solution {
    public int compress(char[] chars) {
        
        int n = chars.length;
        int i = 0;
        int j = 0;
        while (i < n) {
            int count = 0;
            char c = chars[i];
            while (i < n && chars[i] == c) {
                i++;
                count++;
            }
            chars[j++] = c;
            if (count > 1) {
                for (char ch: Integer.toString(count).toCharArray()) {
                    chars[j++] = ch;
                }
            }
        }
        return j;
    }
}