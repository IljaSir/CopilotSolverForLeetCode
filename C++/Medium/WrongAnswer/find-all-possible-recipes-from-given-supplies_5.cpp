class Solution {
public:
    vector<string> findAllRecipes(vector<string>& recipes, vector<vector<string>>& ingredients, vector<string>& supplies) {
        
        unordered_map<string, vector<string>> recipeMap;
        unordered_map<string, int> supplyMap;
        for (int i = 0; i < recipes.size(); i++) {
            for (string& ingredient : ingredients[i]) {
                recipeMap[ingredient].push_back(recipes[i]);
            }
        }
        for (string& supply : supplies) {
            supplyMap[supply]++;
        }
        vector<string> res;
        for (int i = 0; i < recipes.size(); i++) {
            if (canMake(recipeMap, supplyMap, recipes[i])) {
                res.push_back(recipes[i]);
            }
        }
        return res;
    }
    
    bool canMake(unordered_map<string, vector<string>>& recipeMap, unordered_map<string, int>& supplyMap, string& recipe) {
        if (supplyMap.count(recipe)) {
            return true;
        }
        if (recipeMap.count(recipe)) {
            for (string& ingredient : recipeMap[recipe]) {
                if (!canMake(recipeMap, supplyMap, ingredient)) {
                    return false;
                }
            }
            supplyMap[recipe]++;
            return true;
        }
        return false;
    }
};