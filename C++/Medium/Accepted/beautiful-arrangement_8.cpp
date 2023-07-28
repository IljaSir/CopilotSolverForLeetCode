class Solution {
public:
    int countArrangement(int n) {
        
        vector<bool> used(n+1, false);
        int res = 0;
        backtrack(n, 1, res, used);
        return res;
    }
    
    void backtrack(int n, int pos, int& res, vector<bool>& used) {
        if (pos > n) {
            ++res;
            return;
        }
        for (int i = 1; i <= n; ++i) {
            if (used[i]) continue;
            if (i % pos == 0 || pos % i == 0) {
                used[i] = true;
                backtrack(n, pos+1, res, used);
                used[i] = false;
            }
        }
    }
};