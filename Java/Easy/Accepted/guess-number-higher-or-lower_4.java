class Solution extends GuessGame {
    public int guessNumber(int n) {
        
        int lo = 1;
        int hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == -1) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}