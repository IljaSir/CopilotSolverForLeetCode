class Solution {
public:
    vector<string> addOperators(string num, int target) {
        
        vector<string> res;
        string path;
        dfs(num, target, 0, 0, 0, path, res);
        return res;
    }
    void dfs(string& num, int target, int pos, long long pre, long long cur, string path, vector<string>& res) {
        if (pos == num.size()) {
            if (cur == target) res.push_back(path);
            return;
        }
        for (int i = pos; i < num.size(); i++) {
            if (i != pos && num[pos] == '0') break;
            string t = num.substr(pos, i - pos + 1);
            long long val = stoll(t);
            if (pos == 0) {
                dfs(num, target, i + 1, val, val, t, res);
            } else {
                dfs(num, target, i + 1, val, cur + val, path + "+" + t, res);
                dfs(num, target, i + 1, -val, cur - val, path + "-" + t, res);
                dfs(num, target, i + 1, pre * val, cur - pre + pre * val, path + "*" + t, res);
            }
        }
    }
};