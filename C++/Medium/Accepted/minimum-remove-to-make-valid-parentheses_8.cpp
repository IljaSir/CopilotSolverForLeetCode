class Solution {
public:
    string minRemoveToMakeValid(string s) {
        
        int n = s.size();
        vector<int> stack;
        for (int i = 0; i < n; i++) {
            if (s[i] == '(') {
                stack.push_back(i);
            } else if (s[i] == ')') {
                if (!stack.empty()) {
                    stack.pop_back();
                } else {
                    s[i] = ' ';
                }
            }
        }
        for (int i : stack) {
            s[i] = ' ';
        }
        s.erase(remove(s.begin(), s.end(), ' '), s.end());
        return s;
    }
};