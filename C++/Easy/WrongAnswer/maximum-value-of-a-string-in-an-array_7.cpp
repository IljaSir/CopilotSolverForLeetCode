class Solution {
public:
    int maximumValue(vector<string>& strs) {
        
        int max = 0;
        for(auto str : strs) {
            int val = 0;
            if(isdigit(str[0])) {
                val = stoi(str);
            } else {
                val = str.length();
            }
            if(val > max) max = val;
        }
        return max;
    }
};