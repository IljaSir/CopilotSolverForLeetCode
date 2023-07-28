class Solution {
public:
    vector<string> maxNumOfSubstrings(string s) {
        
        vector<int> left(26, s.size()), right(26, -1);
        for (int i = 0; i < s.size(); ++i) {
            int c = s[i] - 'a';
            left[c] = min(left[c], i);
            right[c] = max(right[c], i);
        }
        vector<int> stack;
        for (int i = 0; i < s.size(); ++i) {
            if (i == left[s[i] - 'a']) {
                int l = i, r = right[s[i] - 'a'];
                while (l < r) {
                    r = max(r, right[s[l++] - 'a']);
                }
                while (stack.size() && left[s[stack.back()] - 'a'] >= l) {
                    stack.pop_back();
                }
                if (stack.size() == 0 || right[s[stack.back()] - 'a'] < l) {
                    stack.push_back(i);
                }
            }
        }
        vector<string> ans;
        for (int i = 0; i < stack.size(); ++i) {
            ans.push_back(s.substr(stack[i], right[s[stack[i]] - 'a'] - stack[i] + 1));
        }
        return ans;
    }
};