class Solution {
public:
    int getLastMoment(int n, vector<int>& left, vector<int>& right) {
        
        int l = 0, r = 0;
        for (auto x : left) {
            l = max(l, x);
        }
        for (auto x : right) {
            r = max(r, n - x);
        }
        return max(l, r);
    }
};