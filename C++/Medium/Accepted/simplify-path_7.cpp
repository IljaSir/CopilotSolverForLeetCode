class Solution {
public:
    string simplifyPath(string path) {
        
        int i, j, k;
        i = 0;
        vector<string> stk;
        while (i < path.size()) {
            if (path[i] == '/') {
                i++;
                continue;
            }
            j = i;
            while (j < path.size() && path[j] != '/') j++;
            string s = path.substr(i, j - i);
            if (s == ".") {
                i = j;
                continue;
            }
            if (s == "..") {
                if (!stk.empty()) stk.pop_back();
            } else {
                stk.push_back(s);
            }
            i = j;
        }
        string ans;
        for (auto &s : stk) {
            ans += "/" + s;
        }
        if (ans.empty()) ans = "/";
        return ans;
    }
};