class Solution {
public:
    string removeDuplicates(string s, int k) {
        
        stack<pair<char, int>> stk;
        for (char c : s) {
            if (stk.empty() || stk.top().first != c) {
                stk.push({c, 1});
            } else {
                if (++stk.top().second == k) stk.pop();
            }
        }
        string res;
        while (!stk.empty()) {
            auto p = stk.top();
            stk.pop();
            res.insert(0, p.second, p.first);
        }
        return res;
    }
};