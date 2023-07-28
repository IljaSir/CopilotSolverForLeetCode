class Solution {
public:
    int minimizedMaximum(int n, vector<int>& quantities) {
        
        int l = 1, r = 1e5;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(n, quantities, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    
    bool check(int n, vector<int>& quantities, int x) {
        int count = 0;
        for (int i = 0; i < quantities.size(); ++i) {
            count += (quantities[i] - 1) / x + 1;
        }
        return count <= n;
    }
};