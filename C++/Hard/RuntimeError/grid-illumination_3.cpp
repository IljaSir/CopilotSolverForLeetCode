class Solution {
public:
    vector<int> gridIllumination(int n, vector<vector<int>>& lamps, vector<vector<int>>& queries) {
        
        vector<int> ans;
        unordered_map<int, int> row, col, diag1, diag2;
        unordered_set<long long> lamp;
        for (auto& l: lamps) {
            int r = l[0], c = l[1];
            row[r]++;
            col[c]++;
            diag1[r - c]++;
            diag2[r + c]++;
            lamp.insert(((long long)r << 32) | c);
        }
        for (auto& q: queries) {
            int r = q[0], c = q[1];
            if (row[r] || col[c] || diag1[r - c] || diag2[r + c]) {
                ans.push_back(1);
            } else {
                ans.push_back(0);
            }
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int nr = r + i, nc = c + j;
                    if (lamp.count(((long long)nr << 32) | nc)) {
                        lamp.erase(((long long)nr << 32) | nc);
                        row[nr]--;
                        col[nc]--;
                        diag1[nr - nc]--;
                        diag2[nr + nc]--;
                    }
                }
            }
        }
        return ans;
    }
};