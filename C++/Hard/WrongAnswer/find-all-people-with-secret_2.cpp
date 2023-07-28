class Solution {
public:
    vector<int> findAllPeople(int n, vector<vector<int>>& meetings, int firstPerson) {
        
        vector<vector<int>> m(n);
        for (auto& v : meetings) {
            m[v[0]].push_back(v[1]);
            m[v[1]].push_back(v[0]);
        }
        vector<bool> visited(n);
        vector<int> ans;
        function<void(int)> dfs = [&](int i) {
            if (visited[i]) return;
            visited[i] = true;
            ans.push_back(i);
            for (int j : m[i]) dfs(j);
        };
        dfs(firstPerson);
        return ans;
    }
};