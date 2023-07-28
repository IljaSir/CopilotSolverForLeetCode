class Solution {
public:
    int guessNumber(int n) {
        
        int left = 1;
        int right = n;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            } else if (res == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return mid;
    }
};