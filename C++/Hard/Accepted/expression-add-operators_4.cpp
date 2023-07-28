class Solution {
public:
    vector<string> addOperators(string num, int target) {
        
        vector<string> res;
        if(num.empty()) return res;
        dfs(num, target, 0, "", 0, 0, res);
        return res;
    }
    void dfs(string num, int target, int pos, string path, long long prev, long long cur, vector<string>& res) {
        if(pos == num.size()) {
            if(cur == target) {
                res.push_back(path);
            }
            return;
        }
        for(int i = pos; i < num.size(); i++) {
            string t = num.substr(pos, i-pos+1);
            if(t.size() > 1 && t[0] == '0') return;
            long long n = stoll(t);
            if(pos == 0) {
                dfs(num, target, i+1, t, n, n, res);
            } else {
                dfs(num, target, i+1, path + "+" + t, n, cur + n, res);
                dfs(num, target, i+1, path + "-" + t, -n, cur - n, res);
                dfs(num, target, i+1, path + "*" + t, prev * n, cur - prev + prev * n, res);
            }
        }
    }
};