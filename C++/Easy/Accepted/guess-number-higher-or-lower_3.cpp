class Solution {
public:
    int guessNumber(int n) {
        
        int l = 1, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int res = guess(mid);
            if (res == 0) return mid;
            else if (res == 1) l = mid + 1;
            else r = mid;
        }
        return l;
    }
};