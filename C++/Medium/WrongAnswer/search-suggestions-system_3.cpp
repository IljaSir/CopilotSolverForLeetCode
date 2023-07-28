class Solution {
public:
    vector<vector<string>> suggestedProducts(vector<string>& products, string searchWord) {
        
        vector<vector<string>> result;
        sort(products.begin(), products.end());
        for (int i = 0; i < searchWord.size(); ++i) {
            vector<string> temp;
            for (auto& product : products) {
                if (product.size() > i && product[i] == searchWord[i]) {
                    temp.push_back(product);
                }
                if (temp.size() == 3) {
                    break;
                }
            }
            result.push_back(temp);
            products = temp;
        }
        return result;
    }
};