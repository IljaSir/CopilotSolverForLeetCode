class Solution {
public:
    vector<int> splitIntoFibonacci(string num) {
        
        vector<int> ans;
        dfs(ans, num, 0);
        return ans;
    }
    bool dfs(vector<int>& ans, string& num, int start) {
        if (start == num.size() && ans.size() >= 3) return true;
        for (int i = start; i < num.size(); ++i) {
            if (i > start && num[start] == '0') break;
            long long n = stoll(num.substr(start, i - start + 1));
            if (n > INT_MAX) break;
            int sz = ans.size();
            if (sz >= 2 && n > ans[sz - 1] + ans[sz - 2]) break;
            if (sz <= 1 || n == ans[sz - 1] + ans[sz - 2]) {
                ans.push_back(n);
                if (dfs(ans, num, i + 1)) return true;
                ans.pop_back();
            }
        }
        return false;
    }
};