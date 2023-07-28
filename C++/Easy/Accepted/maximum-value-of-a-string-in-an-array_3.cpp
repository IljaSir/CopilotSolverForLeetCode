class Solution {
public:
    int maximumValue(vector<string>& strs) {
        
        int max = 0;
        for(int i=0; i<strs.size(); i++) {
            int val = 0;
            for(int j=0; j<strs[i].length(); j++) {
                if(strs[i][j] >= 'a' && strs[i][j] <= 'z') {
                    val = strs[i].length();
                    break;
                }
            }
            if(val == 0) {
                val = stoi(strs[i]);
            }
            if(val > max) {
                max = val;
            }
        }
        return max;
    }
};