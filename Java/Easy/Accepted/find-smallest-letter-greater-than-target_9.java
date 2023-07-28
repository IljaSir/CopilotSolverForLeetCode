class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        int n = letters.length;
        int l = 0, r = n - 1;
        while(l < r) {
            int mid = (l + r) >> 1;
            if(letters[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return letters[l] > target ? letters[l] : letters[0];
    }
}