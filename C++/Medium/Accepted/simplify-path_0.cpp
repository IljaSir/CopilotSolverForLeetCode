class Solution {
public:
    string simplifyPath(string path) {
        
        stack<string> s;
        int i = 0;
        int n = path.size();
        while (i < n) {
            while (i < n && path[i] == '/') {
                i++;
            }
            if (i == n) {
                break;
            }
            int j = i;
            while (j < n && path[j] != '/') {
                j++;
            }
            string dir = path.substr(i, j - i);
            if (dir == "..") {
                if (!s.empty()) {
                    s.pop();
                }
            }
            else if (dir != ".") {
                s.push(dir);
            }
            i = j;
        }
        if (s.empty()) {
            return "/";
        }
        string ans;
        while (!s.empty()) {
            ans = "/" + s.top() + ans;
            s.pop();
        }
        return ans;
    }
};