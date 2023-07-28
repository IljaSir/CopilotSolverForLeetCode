class Solution {
public:
    vector<int> numsSameConsecDiff(int n, int k) {
        
        vector<int> res;
        for (int i = 1; i < 10; i++) {
            dfs(res, n - 1, k, i);
        }
        if (n == 1) res.push_back(0);
        return res;
    }
    
    void dfs(vector<int>& res, int n, int k, int num) {
        if (n == 0) {
            res.push_back(num);
            return;
        }
        int tail = num % 10;
        int a = tail + k;
        int b = tail - k;
        if (a < 10) dfs(res, n - 1, k, num * 10 + a);
        if (b >= 0 && k != 0) dfs(res, n - 1, k, num * 10 + b);
    }
};