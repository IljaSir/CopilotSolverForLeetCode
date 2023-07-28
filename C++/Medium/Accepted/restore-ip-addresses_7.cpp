class Solution {
public:
    vector<string> restoreIpAddresses(string s) {
        
        vector<string> res;
        DFS(s, 0, 0, "", res);
        return res;
    }
    void DFS(string s, int index, int count, string out, vector<string>& res) {
        if (index == s.size() && count == 4) {
            res.push_back(out);
            return;
        }
        if (index == s.size() || count == 4) return;
        for (int i = 1; i <= 3; i++) {
            if (index + i > s.size()) break;
            string tmp = s.substr(index, i);
            if ((tmp[0] == '0' && tmp.size() > 1) || (i == 3 && stoi(tmp) > 255)) continue;
            DFS(s, index + i, count + 1, out + tmp + (count == 3 ? "" : "."), res);
        }
    }
};