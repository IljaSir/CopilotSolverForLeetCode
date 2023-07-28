class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        
        vector<int> res;
        if(temperatures.size() == 0) return res;
        for(int i = 0; i < temperatures.size(); i++) {
            int j = i + 1;
            for(; j < temperatures.size(); j++) {
                if(temperatures[j] > temperatures[i]) {
                    res.push_back(j - i);
                    break;
                }
            }
            if(j == temperatures.size()) res.push_back(0);
        }
        return res;
    }
};