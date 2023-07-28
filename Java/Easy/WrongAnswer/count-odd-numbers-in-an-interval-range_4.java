class Solution {
    public int countOdds(int low, int high) {
        
        int diff = high - low;
        if (diff % 2 == 0) {
            return diff / 2 + (low % 2 == 0 ? 0 : 1);
        } else {
            return diff / 2 + (high % 2 == 0 ? 0 : 1);
        }
    }
}