class Solution {
    public int compress(char[] chars) {
        
        int i = 0, j = 0;
        while (i < chars.length) {
            int count = 0;
            char cur = chars[i];
            while (i < chars.length && chars[i] == cur) {
                i++;
                count++;
            }
            chars[j++] = cur;
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[j++] = c;
                }
            }
        }
        return j;
    }
}