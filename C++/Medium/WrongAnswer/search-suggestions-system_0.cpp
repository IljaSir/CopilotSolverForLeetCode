class Solution {
public:
    vector<vector<string>> suggestedProducts(vector<string>& products, string searchWord) {
        
        vector<vector<string>> result;
        sort(products.begin(), products.end());
        for (int i = 0; i < searchWord.size(); ++i) {
            vector<string> temp;
            for (int j = 0; j < products.size(); ++j) {
                if (products[j].size() > i && products[j][i] == searchWord[i]) {
                    temp.push_back(products[j]);
                }
                if (temp.size() == 3) {
                    break;
                }
            }
            result.push_back(temp);
        }
        return result;
    }
};