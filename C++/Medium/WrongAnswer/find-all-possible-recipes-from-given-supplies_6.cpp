class Solution {
public:
    vector<string> findAllRecipes(vector<string>& recipes, vector<vector<string>>& ingredients, vector<string>& supplies) {
        
        unordered_map<string, int> m;
        for (auto& s : supplies) m[s]++;
        vector<string> res;
        for (int i = 0; i < recipes.size(); i++) {
            bool found = true;
            for (auto& s : ingredients[i]) {
                if (m[s] == 0) {
                    found = false;
                    break;
                }
            }
            if (found) res.push_back(recipes[i]);
        }
        return res;
    }
};