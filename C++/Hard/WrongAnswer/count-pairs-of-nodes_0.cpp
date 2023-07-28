class Solution {
public:
    vector<int> countPairs(int n, vector<vector<int>>& edges, vector<int>& queries) {
        
        vector<int> ans;
        for (int q : queries) {
            int count = 0;
            for (int i = 0; i < edges.size(); i++) {
                for (int j = i + 1; j < edges.size(); j++) {
                    if (edges[i][0] != edges[j][0] && edges[i][0] != edges[j][1] && edges[i][1] != edges[j][0] && edges[i][1] != edges[j][1]) {
                        continue;
                    }
                    int cnt = 0;
                    for (int k = 0; k < edges.size(); k++) {
                        if (k == i || k == j) {
                            continue;
                        }
                        if (edges[i][0] == edges[k][0] || edges[i][0] == edges[k][1] || edges[i][1] == edges[k][0] || edges[i][1] == edges[k][1]) {
                            cnt++;
                        }
                    }
                    if (cnt > q) {
                        count++;
                    }
                }
            }
            ans.push_back(count);
        }
        return ans;
    }
};