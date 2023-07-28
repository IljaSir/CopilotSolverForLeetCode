class Solution {
public:
    vector<vector<string>> suggestedProducts(vector<string>& products, string searchWord) {
        
        vector<vector<string>> result;
        sort(products.begin(), products.end());
        for (int i = 1; i <= searchWord.size(); ++i) {
            string prefix = searchWord.substr(0, i);
            auto it = lower_bound(products.begin(), products.end(), prefix);
            vector<string> temp;
            for (int j = 0; j < 3 && it != products.end(); ++j) {
                if (it->substr(0, i) == prefix) {
                    temp.push_back(*it);
                    ++it;
                }
            }
            result.push_back(temp);
        }
        return result;
    }
};