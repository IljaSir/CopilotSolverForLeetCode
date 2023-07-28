class Solution {
public:
    vector<string> findAllRecipes(vector<string>& recipes, vector<vector<string>>& ingredients, vector<string>& supplies) {
        
        unordered_map<string, unordered_set<string>> ingre;
        unordered_map<string, int> supply;
        for (auto &s : supplies) {
            supply[s]++;
        }
        for (int i = 0; i < recipes.size(); i++) {
            for (auto &s : ingredients[i]) {
                ingre[recipes[i]].insert(s);
            }
        }
        vector<string> res;
        for (auto &r : recipes) {
            if (canMake(r, ingre, supply)) {
                res.push_back(r);
            }
        }
        return res;
    }
    bool canMake(string &r, unordered_map<string, unordered_set<string>> &ingre, unordered_map<string, int> &supply) {
        for (auto &s : ingre[r]) {
            if (supply.find(s) == supply.end()) {
                if (!canMake(s, ingre, supply)) return false;
            }
        }
        return true;
    }
};