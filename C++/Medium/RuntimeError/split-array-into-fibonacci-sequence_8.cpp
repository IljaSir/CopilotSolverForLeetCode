class Solution {
public:
    vector<int> splitIntoFibonacci(string num) {
        
        vector<int> res;
        int n = num.size();
        function<bool(int, int, int)> dfs = [&](int i, int j, int k) {
            if (i == n) return res.size() >= 3;
            long long x = stoll(num.substr(i, j - i + 1));
            if (x > INT_MAX) return false;
            if (res.size() < 2 || res[k] + res[k + 1] == x) {
                res.push_back(x);
                if (dfs(j + 1, j + 1, k + 1)) return true;
                res.pop_back();
            }
            return false;
        };
        for (int j = 0; j < n; ++j) {
            if (num[0] == '0' && j > 0) break;
            res.clear();
            if (dfs(0, j, -1)) return res;
        }
        return {};
    }
};