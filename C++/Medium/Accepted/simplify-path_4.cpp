class Solution {
public:
    string simplifyPath(string path) {
        
        if (path.empty()) return "";
        vector<string> stk;
        int i = 0;
        while (i < path.size()) {
            if (path[i] == '/') {
                ++i;
                continue;
            }
            int j = i + 1;
            while (j < path.size() && path[j] != '/') ++j;
            string s = path.substr(i, j - i);
            if (s == "..") {
                if (!stk.empty()) stk.pop_back();
            } else if (s != ".") {
                stk.push_back(s);
            }
            i = j;
        }
        string ret = "";
        for (const string& s : stk) {
            ret += "/" + s;
        }
        if (ret.empty()) ret = "/";
        return ret;
    }
};