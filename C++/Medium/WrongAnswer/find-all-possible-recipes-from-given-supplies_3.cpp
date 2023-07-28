class Solution {
public:
    vector<string> findAllRecipes(vector<string>& recipes, vector<vector<string>>& ingredients, vector<string>& supplies) {
        
        vector<string> ans;
        int n = recipes.size();
        unordered_map<string, vector<int>> mp;
        for (int i = 0; i < n; ++i) {
            for (string& s : ingredients[i]) mp[s].push_back(i);
        }
        vector<bool> vis(n, false);
        for (string& s : supplies) {
            for (int i : mp[s]) {
                if (vis[i]) continue;
                vis[i] = true;
                ans.push_back(recipes[i]);
            }
        }
        return ans;
    }
};