class Solution {
public:
    string simplifyPath(string path) {
        
        int n = path.size();
        if (n == 0) return "";
        vector<string> stack;
        int i = 0;
        while (i < n) {
            while (i < n && path[i] == '/') ++i;
            if (i == n) break;
            int start = i;
            while (i < n && path[i] != '/') ++i;
            int end = i;
            string dir = path.substr(start, end - start);
            if (dir == ".") continue;
            if (dir == "..") {
                if (!stack.empty()) stack.pop_back();
            } else {
                stack.push_back(dir);
            }
        }
        string ans = "";
        for (string dir: stack) {
            ans += "/" + dir;
        }
        if (ans == "") ans = "/";
        return ans;
    }
};