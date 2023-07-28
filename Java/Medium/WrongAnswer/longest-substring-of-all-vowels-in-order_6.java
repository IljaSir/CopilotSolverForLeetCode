class Solution {
    public int longestBeautifulSubstring(String word) {
        
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int[] last = new int[5];
        int[] count = new int[5];
        int max = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int pos = Arrays.binarySearch(vowels, ch);
            if (pos == -1) {
                Arrays.fill(count, 0);
                continue;
            }
            if (pos > 0) {
                if (last[pos - 1] >= last[pos]) {
                    Arrays.fill(count, 0);
                }
            }
            last[pos] = i;
            count[pos] = count[pos] + 1;
            if (pos == 4) {
                max = Math.max(max, i - last[0] + 1);
            }
        }
        return max;
    }
}