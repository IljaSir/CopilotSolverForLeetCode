class Solution {
public:
    int maximumValue(vector<string>& strs) {
        
        int max = 0;
        for (int i = 0; i < strs.size(); i++) {
            int temp = 0;
            for (int j = 0; j < strs[i].size(); j++) {
                if (strs[i][j] >= '0' && strs[i][j] <= '9') {
                    temp = temp * 10 + (strs[i][j] - '0');
                } else {
                    temp = strs[i].size();
                    break;
                }
            }
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }
};