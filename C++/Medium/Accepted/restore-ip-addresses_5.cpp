class Solution {
public:
    vector<string> restoreIpAddresses(string s) {
        
        vector<string> res;
        string path;
        dfs(0, 0, s, path, res);
        return res;
    }
    void dfs(int start, int step, string s, string path, vector<string>& res) {
        if (start == s.size() && step == 4) {
            res.push_back(path);
            return;
        }
        if (s.size() - start > (4 - step) * 3) return;
        if (s.size() - start < (4 - step)) return;
        int num = 0;
        for (int i = start; i < start + 3; i++) {
            num = num * 10 + (s[i] - '0');
            if (num <= 255) {
                path += s[i];
                dfs(i + 1, step + 1, s, path + (step == 3 ? "" : "."), res);
            }
            if (num == 0) break;
        }
    }
};