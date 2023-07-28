class Solution {
public:
    int minimizedMaximum(int n, vector<int>& quantities) {
        
        int l = 1, r = 1e9;
        while (l < r) {
            int mid = (l + r) / 2;
            if (check(n, quantities, mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }
    
    bool check(int n, vector<int>& quantities, int x) {
        int sum = 0;
        for (int q : quantities) {
            sum += (q + x - 1) / x;
        }
        return sum <= n;
    }
};