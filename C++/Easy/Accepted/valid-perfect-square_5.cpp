class Solution {
public:
    bool isPerfectSquare(int num) {
        
        if (num == 1) return true;
        int l = 1, r = num / 2;
        while (l < r) {
            int mid = l + (r - l) / 2;
            long long sq = (long long) mid * mid;
            if (sq == num) return true;
            else if (sq < num) l = mid + 1;
            else r = mid;
        }
        return (long long) l * l == num;
    }
};