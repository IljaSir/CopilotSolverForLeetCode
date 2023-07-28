class Solution {
public:
    vector<string> findAllRecipes(vector<string>& recipes, vector<vector<string>>& ingredients, vector<string>& supplies) {
        
        unordered_map<string, vector<string>> recipeMap;
        unordered_set<string> supplySet;
        for (auto& recipe : recipes) {
            recipeMap[recipe] = {};
        }
        for (auto& ingredient : ingredients) {
            for (auto& ingredientItem : ingredient) {
                if (recipeMap.find(ingredientItem) != recipeMap.end()) {
                    recipeMap[ingredientItem].push_back(ingredient[0]);
                }
            }
        }
        for (auto& supply : supplies) {
            supplySet.insert(supply);
        }
        vector<string> result;
        for (auto& recipe : recipes) {
            if (canCreate(recipe, recipeMap, supplySet)) {
                result.push_back(recipe);
            }
        }
        return result;
    }
    
    bool canCreate(string& recipe, unordered_map<string, vector<string>>& recipeMap, unordered_set<string>& supplySet) {
        if (supplySet.find(recipe) != supplySet.end()) {
            return true;
        }
        if (recipeMap[recipe].empty()) {
            return false;
        }
        for (auto& ingredient : recipeMap[recipe]) {
            if (!canCreate(ingredient, recipeMap, supplySet)) {
                return false;
            }
        }
        supplySet.insert(recipe);
        return true;
    }
};