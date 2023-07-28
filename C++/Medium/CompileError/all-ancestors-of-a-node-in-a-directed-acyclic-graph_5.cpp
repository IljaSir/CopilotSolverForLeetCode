class Solution {
public:
    vector<vector<int>> getAncestors(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> adj(n);
        vector<vector<int>> ans(n);
        for (auto& e : edges) {
            adj[e[1]].push_back(e[0]);
        }
        for (int i = 0;egree[v] == 0) {
                    q.push(v);
                }
            }
        }
        return ans;
    }
};