class Solution {
public:
    vector<int> gridIllumination(int n, vector<vector<int>>& lamps, vector<vector<int>>& queries) {
        
        unordered_map<int, int> row, col, diag1, diag2;
        unordered_set<int> lampSet;
        for (auto& lamp : lamps) {
            int x = lamp[0], y = lamp[1];
            row[x]++;
            col[y]++;
            diag1[x + y]++;
            diag2[x - y]++;
            lampSet.insert(x * n + y);
        }
        vector<int> ans;
        for (auto& query : queries) {
            int x = query[0], y = query[1];
            if (row[x] > 0 || col[y] > 0 || diag1[x + y] > 0 || diag2[x - y] > 0) {
                ans.push_back(1);
            } else {
                ans.push_back(0);
            }
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    if (lampSet.count(i * n + j)) {
                        row[i]--;
                        col[j]--;
                        diag1[i + j]--;
                        diag2[i - j]--;
                        lampSet.erase(i * n + j);
                    }
                }
            }
        }
        return ans;
    }
};