class Solution {
public:
    vector<vector<string>> suggestedProducts(vector<string>& products, string searchWord) {
        
        vector<vector<string>> result;
        int n = products.size();
        int m = searchWord.size();
        sort(products.begin(), products.end());
        for (int i = 0; i < m; ++i) {
            vector<string> tmp;
            for (int j = 0; j < n; ++j) {
                if (products[j][i] == searchWord[i]) {
                    tmp.push_back(products[j]);
                }
                if (tmp.size() == 3) {
                    break;
                }
            }
            result.push_back(tmp);
        }
        return result;
    }
};