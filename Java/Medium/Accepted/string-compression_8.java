class Solution {
    public int compress(char[] chars) {
        
        int n = chars.length;
        int i = 0;
        int j = 0;
        int k = 0;
        int count = 0;
        while (i < n) {
            count = 0;
            while (j < n && chars[i] == chars[j]) {
                j++;
                count++;
            }
            chars[k++] = chars[i];
            if (count > 1) {
                String s = String.valueOf(count);
                for (char c : s.toCharArray()) {
                    chars[k++] = c;
                }
            }
            i = j;
        }
        return k;
    }
}