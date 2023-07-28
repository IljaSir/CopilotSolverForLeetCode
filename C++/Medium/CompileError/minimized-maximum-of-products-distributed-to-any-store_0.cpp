class Solution {
public:
    int minimizedMaximum(int n, vector<int>& quantities) {
        
        int left = 1, right = 1e9;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(n, quantities, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
};