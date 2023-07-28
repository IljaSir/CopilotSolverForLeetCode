class Solution {
public:
    int maximumValue(vector<string>& strs) {
        
        int max = 0;
        for (int i = 0; i < strs.size(); i++) {
            int value = 0;
            for (int j = 0; j < strs[i].size(); j++) {
                if (strs[i][j] >= '0' && strs[i][j] <= '9') {
                    value = value * 10 + (strs[i][j] - '0');
                }
                else {
                    value = strs[i].size();
                    break;
                }
            }
            if (value > max)
                max = value;
        }
        return max;
    }
};