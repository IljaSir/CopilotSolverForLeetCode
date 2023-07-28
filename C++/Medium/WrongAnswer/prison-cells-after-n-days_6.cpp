class Solution {
public:
    vector<int> prisonAfterNDays(vector<int>& cells, int n) {
        
        map<vector<int>, int> m;
        int cnt = 0;
        while (true) {
            vector<int> tmp = cells;
            for (int i = 1; i < 7; i++) {
                if (tmp[i - 1] == tmp[i + 1]) {
                    cells[i] = 1;
                } else {
                    cells[i] = 0;
                }
            }
            cnt++;
            if (m.find(cells) != m.end()) {
                break;
            }
            m[cells] = cnt;
        }
        n = (n - 1) % cnt + 1;
        for (auto it = m.begin(); it != m.end(); it++) {
            if (it->second == n) {
                return it->first;
            }
        }
        return cells;
    }
};