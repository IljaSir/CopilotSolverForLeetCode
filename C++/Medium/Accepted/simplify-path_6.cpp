class Solution {
public:
    string simplifyPath(string path) {
        
        vector<string> v;
        string res = "";
        int i = 0;
        while (i < path.size()) {
            if (path[i] == '/') {
                i++;
                continue;
            }
            string tmp = "";
            while (i < path.size() && path[i] != '/') {
                tmp += path[i];
                i++;
            }
            if (tmp == "..") {
                if (!v.empty()) {
                    v.pop_back();
                }
            } else if (tmp != ".") {
                v.push_back(tmp);
            }
        }
        for (string s : v) {
            res += "/" + s;
        }
        return res.empty() ? "/" : res;
    }
};