class Solution {
public:
    vector<bool> camelMatch(vector<string>& queries, string pattern) {
        
        vector<bool> ans;
        for (auto &q: queries) {
            int i = 0, j = 0;
            for (; i < q.length() && j < pattern.length(); ++i) {
                if (q[i] == pattern[j]) {
                    ++j;
                } else if (q[i] >= 'A' && q[i] <= 'Z') {
                    break;
                }
            }
            if (j == pattern.length()) {
                for (; i < q.length(); ++i) {
                    if (q[i] >= 'A' && q[i] <= 'Z') {
                        break;
                    }
                }
                ans.push_back(i == q.length());
            } else {
                ans.push_back(false);
            }
        }
        return ans;
    }
};