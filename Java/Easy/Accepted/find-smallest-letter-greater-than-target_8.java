class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        int low = 0;
        int high = letters.length - 1;
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return letters[low] > target ? letters[low] : letters[0];
    }
}