class Solution {
public:
    vector<string> findAllRecipes(vector<string>& recipes, vector<vector<string>>& ingredients, vector<string>& supplies) {
        
        unordered_map<string, int> supply;
        for (auto& s : supplies) {
            supply[s]++;
        }
        vector<string> result;
        for (int i = 0; i < recipes.size(); ++i) {
            if (canMake(recipes[i], ingredients[i], supply)) {
                result.push_back(recipes[i]);
            }
        }
        return result;
    }
};