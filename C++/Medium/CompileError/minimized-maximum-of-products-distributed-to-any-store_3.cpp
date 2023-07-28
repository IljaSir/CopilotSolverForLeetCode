class Solution {
public:
    int minimizedMaximum(int n, vector<int>& quantities) {
        
        int l = 1, r = 1e9;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (check(n, quantities, m)) r = m;
            else l = m + 1;
        }
        return l;
    }
};