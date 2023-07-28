class Solution {
public:
    vector<string> findAllRecipes(vector<string>& recipes, vector<vector<string>>& ingredients, vector<string>& supplies) {
        
        vector<string> res;
        unordered_map<string, int> supply;
        for (string& s : supplies) {
            supply[s]++;
        }
        for (int i = 0; i < recipes.size(); ++i) {
            if (canMake(supply, ingredients[i])) {
                res.push_back(recipes[i]);
            }
        }
        return res;
    }
    
    bool canMake(unordered_map<string, int>& supply, vector<string>& ingredient) {
        for (string& s : ingredient) {
            if (supply.find(s) == supply.end()) {
                return false;
            }
            supply[s]--;
        }
        return true;
    }
};