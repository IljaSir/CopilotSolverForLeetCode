class Solution {
    public int maxRepOpt1(String text) {
        
        int[] count = new int[26];
        int[] length = new int[26];
        int max = 0;
        int cur = 0;
        int prev = 0;
        char prevChar = ' ';
        for (char c : text.toCharArray()) {
            int index = c - 'a';
            count[index]++;
            if (c != prevChar) {
                cur = 0;
                prev = 0;
                prevChar = c;
            }
            cur++;
            if (count[index] >= cur) {
                prev = cur;
            }
            length[index] = Math.max(length[index], cur + prev);
            max = Math.max(max, length[index]);
        }
        return max;
    }
}