class Solution {
public:
    string simplifyPath(string path) {
        
        int n = path.size();
        vector<string> stack;
        int i = 0;
        while (i < n) {
            if (path[i] == '/') {
                i++;
                continue;
            }
            string s;
            while (i < n && path[i] != '/') {
                s.push_back(path[i++]);
            }
            if (s == ".") {
                continue;
            }
            if (s == "..") {
                if (!stack.empty()) {
                    stack.pop_back();
                }
            } else {
                stack.push_back(s);
            }
        }
        string ans;
        for (auto s : stack) {
            ans += "/";
            ans += s;
        }
        if (ans.empty()) {
            ans = "/";
        }
        return ans;
    }
};