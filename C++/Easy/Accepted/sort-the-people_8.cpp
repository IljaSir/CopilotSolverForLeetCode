class Solution {
public:
    vector<string> sortPeople(vector<string>& names, vector<int>& heights) {
        
        vector<string> result;
        for (int i = 0; i < names.size(); i++) {
            int j = i;
            while (j > 0 && heights[j] > heights[j-1]) {
                int tmp = heights[j];
                heights[j] = heights[j-1];
                heights[j-1] = tmp;
                
                string tmpStr = names[j];
                names[j] = names[j-1];
                names[j-1] = tmpStr;
                j--;
            }
        }
        
        for (int i = 0; i < names.size(); i++) {
            result.push_back(names[i]);
        }
        
        return result;
    }
};