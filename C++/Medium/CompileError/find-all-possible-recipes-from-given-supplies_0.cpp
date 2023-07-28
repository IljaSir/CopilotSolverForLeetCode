class Solution {
public:
    vector<string> findAllRecipes(vector<string>& recipes, vector<vector<string>>& ingredients, vector<string>& supplies) {
        
        unordered_set<string> supplySet;
        for (auto &s : supplies) {
            supplySet.insert(s);
        }
        vector<string> result;
        for (int i = 0; i < recipes.size(); ++i) {
            if (canMake(ingredients[i], supplySet)) {
                result.push_back(recipes[i]);
            }
        }
        return result;
    }
};