class Solution {
public:
    int minimizedMaximum(int n, vector<int>& quantities) {
        
        int left = 1;
        int right = 1e5;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(mid, n, quantities)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    bool check(int x, int n, vector<int>& quantities) {
        int sum = 0;
        for (int i = 0; i < quantities.size(); i++) {
            sum += quantities[i] / x;
        }
        return sum >= n;
    }
};