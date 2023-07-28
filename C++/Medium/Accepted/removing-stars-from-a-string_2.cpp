class Solution {
public:
    string removeStars(string s) {
        
        int n = s.size();
        stack<char> stk;
        for (int i = 0; i < n; ++i) {
            if (s[i] == '*') {
                while (!stk.empty() && stk.top() == '*') stk.pop();
                if (!stk.empty()) stk.pop();
            } else {
                stk.push(s[i]);
            }
        }
        string res;
        while (!stk.empty()) {
            res.push_back(stk.top());
            stk.pop();
        }
        reverse(res.begin(), res.end());
        return res;
    }
};