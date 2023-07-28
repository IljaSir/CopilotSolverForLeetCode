class Solution {
public:
    vector<int> splitIntoFibonacci(string num) {
        
        vector<int> res;
        dfs(res, num, 0, 0, 0);
        return res;
    }
    bool dfs(vector<int>& res, string& num, int pos, int sum, int prev) {
        if (pos == num.size()) return res.size() >= 3;
        long long curr = 0;
        for (int i = pos; i < num.size(); ++i) {
            if (i > pos && num[pos] == '0') break;
            curr = curr * 10 + num[i] - '0';
            if (curr > INT_MAX) break;
            if (res.size() >= 2) {
                if (curr < sum) continue;
                else if (curr > sum) break;
            }
            res.push_back(curr);
            if (dfs(res, num, i + 1, prev + curr, curr)) return true;
            res.pop_back();
        }
        return false;
    }
};