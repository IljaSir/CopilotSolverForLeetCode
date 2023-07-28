class Solution {
    public int compress(char[] chars) {
        
        int i = 0;
        int j = 0;
        int count = 0;
        while (j < chars.length) {
            count = 0;
            while (j < chars.length && chars[i] == chars[j]) {
                j++;
                count++;
            }
            chars[i] = chars[j - 1];
            i++;
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[i] = c;
                    i++;
                }
            }
        }
        return i;
    }
}