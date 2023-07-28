class Solution {
public:
    vector<int> gridIllumination(int n, vector<vector<int>>& lamps, vector<vector<int>>& queries) {
        
        vector<int> ans;
        unordered_set<string> lamp;
        unordered_map<int, int> row;
        unordered_map<int, int> col;
        unordered_map<int, int> diag1;
        unordered_map<int, int> diag2;
        for (auto& l : lamps) {
            lamp.insert(to_string(l[0]) + "," + to_string(l[1]));
            row[l[0]]++;
            col[l[1]]++;
            diag1[l[0] - l[1]]++;
            diag2[l[0] + l[1]]++;
        }
        for (auto& q : queries) {
            if (row[q[0]] > 0 || col[q[1]] > 0 || diag1[q[0] - q[1]] > 0 || diag2[q[0] + q[1]] > 0) {
                ans.push_back(1);
            } else {
                ans.push_back(0);
            }
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int x = q[0] + i;
                    int y = q[1] + j;
                    if (lamp.find(to_string(x) + "," + to_string(y)) != lamp.end()) {
                        lamp.erase(to_string(x) + "," + to_string(y));
                        row[x]--;
                        col[y]--;
                        diag1[x - y]--;
                        diag2[x + y]--;
                    }
                }
            }
        }
        return ans;
    }
};