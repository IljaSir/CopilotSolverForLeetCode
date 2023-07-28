class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        int n = letters.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (letters[m] <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return letters[l % n];
    }
}