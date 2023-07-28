class Solution {
public:
    vector<string> sortPeople(vector<string>& names, vector<int>& heights) {
        
        vector<string> result;
        for (int i = 0; i < names.size(); i++) {
            string name = names[i];
            int height = heights[i];
            int j = result.size() - 1;
            for (; j >= 0; j--) {
                int k = j;
                while (k < result.size() && heights[k] > height) {
                    k++;
                }
                if (k == result.size()) {
                    result.push_back(result[j]);
                } else {
                    result[k] = result[j];
                }
            }
            result[j + 1] = name;
        }
        return result;
    }
};