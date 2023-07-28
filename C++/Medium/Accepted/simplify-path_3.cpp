class Solution {
public:
    string simplifyPath(string path) {
        
        vector<string> v;
        string res;
        int i = 0;
        while (i < path.size()) {
            while (i < path.size() && path[i] == '/') i++;
            if (i == path.size()) break;
            string s;
            while (i < path.size() && path[i] != '/') s += path[i++];
            if (s == "..") {
                if (!v.empty()) v.pop_back();
            } else if (s != ".") {
                v.push_back(s);
            }
        }
        for (auto &s : v) {
            res += "/" + s;
        }
        return res.empty() ? "/" : res;
    }
};