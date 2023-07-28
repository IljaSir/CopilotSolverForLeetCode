class Solution {
public:
    vector<string> maxNumOfSubstrings(string s) {
        
        int n = s.length();
        vector<int> first(26, -1), last(26, -1);
        for (int i = 0; i < n; ++i) {
            if (first[s[i] - 'a'] == -1) first[s[i] - 'a'] = i;
            last[s[i] - 'a'] = i;
        }
        vector<int> stack;
        for (int i = 0; i < n; ++i) {
            if (first[s[i] - 'a'] == i) {
                int end = last[s[i] - 'a'];
                while (stack.size() && stack.back() > i) {
                    end = max(end, last[s[stack.back()] - 'a']);
                    stack.pop_back();
                }
                stack.push_back(end);
            }
        }
        vector<string> result;
        for (int i = 0, j = 0; i < stack.size(); ++i) {
            j = max(j, i);
            while (j < stack.size() && stack[j] <= stack[i]) ++j;
            result.push_back(s.substr(stack[i], j - i));
            i = j - 1;
        }
        return result;
    }
};