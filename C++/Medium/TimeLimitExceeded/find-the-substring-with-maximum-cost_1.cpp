class Solution {
public:
    int maximumCostSubstring(string s, string chars, vector<int>& vals) {
        
        int max = 0;
        for (int i = 0; i < s.size(); i++) {
            int cost = 0;
            for (int j = i; j < s.size(); j++) {
                int index = chars.find(s[j]);
                if (index == string::npos) {
                    cost += s[j] - 'a' + 1;
                } else {
                    cost += vals[index];
                }
                if (cost > max) {
                    max = cost;
                }
            }
        }
        return max;
    }
};