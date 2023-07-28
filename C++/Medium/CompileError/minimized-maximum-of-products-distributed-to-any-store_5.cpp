class Solution {
public:
    int minimizedMaximum(int n, vector<int>& quantities) {
        
        int l = 1, r = 1e5;
        while (l < r) {
            int mid = (l + r) / 2;
            if (check(n, quantities, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
};