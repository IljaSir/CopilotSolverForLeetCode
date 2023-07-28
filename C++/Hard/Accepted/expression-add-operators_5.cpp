class Solution {
public:
    vector<string> addOperators(string num, int target) {
        
        vector<string> ret;
        string tmp;
        dfs(num, target, 0, 0, 0, tmp, ret);
        return ret;
    }
    void dfs(const string &num, int target, int pos, long long prev, long long cur, string &tmp, vector<string> &ret) {
        if (pos == num.size()) {
            if (cur == target) {
                ret.push_back(tmp);
            }
            return;
        }
        int n = num.size();
        for (int i = pos; i < n; ++i) {
            string s = num.substr(pos, i - pos + 1);
            long long val = stoll(s);
            if (to_string(val).size() != s.size()) {
                continue;
            }
            if (pos == 0) {
                tmp += s;
                dfs(num, target, i + 1, val, val, tmp, ret);
                tmp.resize(tmp.size() - s.size());
            } else {
                tmp += "+" + s;
                dfs(num, target, i + 1, val, cur + val, tmp, ret);
                tmp.resize(tmp.size() - s.size() - 1);
                tmp += "-" + s;
                dfs(num, target, i + 1, -val, cur - val, tmp, ret);
                tmp.resize(tmp.size() - s.size() - 1);
                tmp += "*" + s;
                dfs(num, target, i + 1, prev * val, cur - prev + prev * val, tmp, ret);
                tmp.resize(tmp.size() - s.size() - 1);
            }
        }
    }
};