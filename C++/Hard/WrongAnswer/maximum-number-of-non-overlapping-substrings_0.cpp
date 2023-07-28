class Solution {
public:
    vector<string> maxNumOfSubstrings(string s) {
        
        int n = s.size();
        vector<int> left(26, n), right(26, -1);
        for (int i = 0; i < n; ++i) {
            int c = s[i] - 'a';
            left[c] = min(left[c], i);
            right[c] = i;
        }
        vector<int> stack;
        for (int i = 0; i < n; ++i) {
            if (i == left[s[i] - 'a']) {
                stack.push_back(i);
            }
            int c = s[i] - 'a';
            if (right[c] > stack.back()) {
                stack.push_back(right[c]);
            }
        }
        vector<string> res;
        int prev = -1;
        for (int i : stack) {
            if (i > prev) {
                res.push_back(s.substr(prev + 1, i - prev));
                prev = i;
            }
        }
        return res;
    }
};