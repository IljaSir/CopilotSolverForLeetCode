class Solution {
public:
    string makeGood(string s) {
        
        stack<char> stk;
        for (auto& ch : s) {
            if (stk.empty()) {
                stk.push(ch);
            } else {
                if (abs(ch - stk.top()) == 32) {
                    stk.pop();
                } else {
                    stk.push(ch);
                }
            }
        }
        string ans;
        while (!stk.empty()) {
            ans.push_back(stk.top());
            stk.pop();
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};