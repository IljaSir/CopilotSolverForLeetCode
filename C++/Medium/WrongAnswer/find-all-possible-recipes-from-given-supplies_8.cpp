class Solution {
public:
    vector<string> findAllRecipes(vector<string>& recipes, vector<vector<string>>& ingredients, vector<string>& supplies) {
        
        unordered_map<string, vector<string>> ing2recipe; // ingredient to recipe
        unordered_map<string, int> ing2cnt; // ingredient to count
        for (int i = 0; i < recipes.size(); ++i) {
            for (auto& ing : ingredients[i]) {
                ing2recipe[ing].push_back(recipes[i]);
            }
        }
        for (auto& ing : supplies) {
            ++ing2cnt[ing];
        }
        vector<string> ret;
        for (auto& [ing, cnt] : ing2cnt) {
            for (auto& recipe : ing2recipe[ing]) {
                --ing2cnt[recipe];
            }
        }
        for (auto& [recipe, cnt] : ing2cnt) {
            if (cnt == 0) {
                ret.push_back(recipe);
            }
        }
        return ret;
    }
};