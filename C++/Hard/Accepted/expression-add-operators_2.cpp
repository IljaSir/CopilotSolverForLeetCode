class Solution {
public:
    vector<string> addOperators(string num, int target) {
        
        vector<string> res;
        int n = num.size();
        for (int i = 1; i <= n; i++) {
            string s = num.substr(0, i);
            if (s.size() > 1 && s[0] == '0') break;
            long long n = stoll(s);
            dfs(num, target, i, to_string(n), n, n, res);
        }
        return res;
    }
    void dfs(string num, int target, int i, string path, long long cur, long long last, vector<string>& res) {
        if (i == num.size() && cur == target) {
            res.push_back(path);
            return;
        }
        for (int j = i + 1; j <= num.size(); j++) {
            string s = num.substr(i, j - i);
            if (s.size() > 1 && s[0] == '0') break;
            long long n = stoll(s);
            dfs(num, target, j, path + '+' + s, cur + n, n, res);
            dfs(num, target, j, path + '-' + s, cur - n, -n, res);
            dfs(num, target, j, path + '*' + s, cur - last + last * n, last * n, res);
        }
    }
};