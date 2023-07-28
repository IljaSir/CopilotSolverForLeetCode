class Solution {
public:
    vector<int> gridIllumination(int n, vector<vector<int>>& lamps, vector<vector<int>>& queries) {
        
        vector<int> ans;
        unordered_map<int, int> row, col, diag1, diag2;
        unordered_set<int> lamp;
        for (auto& l : lamps) {
            int x = l[0], y = l[1];
            row[x]++;
            col[y]++;
            diag1[x - y]++;
            diag2[x + y]++;
            lamp.insert(x * n + y);
        }
        for (auto& q : queries) {
            int x = q[0], y = q[1];
            if (row[x] > 0 || col[y] > 0 || diag1[x - y] > 0 || diag2[x + y] > 0)
                ans.push_back(1);
            else
                ans.push_back(0);
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    if (lamp.count(i * n + j)) {
                        row[i]--;
                        col[j]--;
                        diag1[i - j]--;
                        diag2[i + j]--;
                        lamp.erase(i * n + j);
                    }
                }
            }
        }
        return ans;
    }
};