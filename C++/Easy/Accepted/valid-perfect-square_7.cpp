class Solution {
public:
    bool isPerfectSquare(int num) {
        
        if (num == 1) return true;
        long long int left = 1, right = num / 2;
        while (left <= right) {
            long long int mid = (left + right) / 2;
            long long int tmp = mid * mid;
            if (tmp == num) {
                return true;
            } else if (tmp < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
};