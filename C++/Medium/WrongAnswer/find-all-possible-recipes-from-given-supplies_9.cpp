class Solution {
public:
    vector<string> findAllRecipes(vector<string>& recipes, vector<vector<string>>& ingredients, vector<string>& supplies) {
        
        int n = recipes.size();
        vector<string> ans;
        vector<vector<string>> adj(n);
        vector<int> in(n, 0);
        map<string, int> mp;
        for (int i = 0; i < n; i++) {
            mp[recipes[i]] = i;
        }
        for (int i = 0; i < n; i++) {
            for (string& s : ingredients[i]) {
                if (mp.count(s)) {
                    adj[mp[s]].push_back(recipes[i]);
                    in[i]++;
                }
            }
        }
        queue<string> q;
        for (string& s : supplies) {
            if (mp.count(s)) {
                q.push(s);
            }
        }
        while (!q.empty()) {
            string s = q.front();
            q.pop();
            ans.push_back(s);
            for (string& t : adj[mp[s]]) {
                if (--in[mp[t]] == 0) {
                    q.push(t);
                }
            }
        }
        return ans;
    }
};