class Solution {
public:
    int maximumCostSubstring(string s, string chars, vector<int>& vals) {
        
        int res = 0;
        for (int i = 0; i < s.size(); ++i) {
            int j = i;
            int sum = 0;
            while (j < s.size()) {
                if (chars.find(s[j]) == string::npos) {
                    sum += s[j] - 'a' + 1;
                } else {
                    sum += vals[chars.find(s[j])];
                }
                res = max(res, sum);
                ++j;
            }
        }
        return res;
    }
};