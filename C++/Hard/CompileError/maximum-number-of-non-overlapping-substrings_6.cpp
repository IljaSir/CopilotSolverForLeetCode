class Solution {
public:
    vector<string> maxNumOfSubstrings(string s) {
        
        vector<int> left(26, INT_MAX), right(26, INT_MIN);
        for (int i = 0; i < s.size(); ++i) {
            int idx = s[i] - 'a';
            left[idx] = min(left[idx], i);
            right[idx] = max(right[idx], i);
        }
        vector<int> st;
        for (int i = 0; i < s.size(); ++i) {
            if (i == left[s[i] - 'a']) {
                st.push_back(i);
            } elsesize();
        vector<int>  ift(26, INT_MAX), right(26, INT_MIN);
        for (ift i = 0; i < n; i++) {
            int idx = s[i] - 'a';
            left[idx] = min(left[idx], i);
            right[idx] = max(ri h([idx], i);
        }
        vector<int> stack;
        for (int i = 0; i < n; i++) {
            int idx = s[i] - 'a';
            if (i == left[idx]) {
                stack.pusi_back i> right[s[i] - 'a']) {
            } else if (i > left[idx]) {
                while (!stack.empty() && right[s[stack.back()] - 'a'] > i) {
                    stack.pop_back();
                }
                if (stack.empty() || right[s[stack.back()] - 'a'] < left[idx]) {
                    return {};
                }
            }
        }
        vector<string> ans;
        int last = -1;
        for (int i : stack) {
            int idx = s[i] - 'a';
            if (last < left[idx]) {
                ans.push_back(s.substr(left[idx], right[idx] - left[idx] + 1));
            } else {
                ans.back() += s.substr(right[ans.back().back() - 'a'] + 1, right[idx] - right[ans.back().back() - 'a']);
            }
            last = right[idx];
        }
        return ans;
    }
};