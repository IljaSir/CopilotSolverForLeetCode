class Solution {
public:
    vector<int> gridIllumination(int n, vector<vector<int>>& lamps, vector<vector<int>>& queries) {
        
        vector<int> ans;
        unordered_map<int, int> row, col;
        unordered_map<int, int> diag1, diag2;
        unordered_set<int> lamp;
        for (auto lamp: lamps) {
            int x = lamp[0], y = lamp[1];
            row[x]++;
            col[y]++;
            diag1[x+y]++;
            diag2[x-y]++;
            lamp.insert(x * n + y);
        }
        for (auto query: queries) {
            int x = query[0], y = query[1];
            if (row[x] || col[y] || diag1[x+y] || diag2[x-y]) {
                ans.push_back(1);
            } else {
                ans.push_back(0);
            }
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int xx = x + i, yy = y + j;
                    if (lamp.count(xx * n + yy)) {
                        lamp.erase(xx * n + yy);
                        row[xx]--;
                        col[yy]--;
                        diag1[xx+yy]--;
                        diag2[xx-yy]--;
                    }
                }
            }
        }
        return ans;
    }
};