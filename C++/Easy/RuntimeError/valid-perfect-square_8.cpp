class Solution {
public:
    bool isPerfectSquare(int num) {
        
        if (num == 1) return true;
        int low = 1, high = num;
        while (low < high) {
            long long mid = (low + high + 1) >> 1;
            long long sq = mid * mid;
            if (sq == num) return true;
            else if (sq > num) high = mid - 1;
            else low = mid;
        }
        return false;
    }
};