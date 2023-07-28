class Solution {
public:
    vector<vector<int>> findWinners(vector<vector<int>>& matches) {
        
        int n = matches.size();
        vector<vector<int>> result(2);
        vector<int> win(n+1, 0);
        vector<int> lose(n+1, 0);
        for (int i = 0; i < n; ++i) {
            win[matches[i][0]]++;
            lose[matches[i][1]]++;
        }
        for (int i = 1; i <= n; ++i) {
            if (lose[i] == 0) {
                result[0].push_back(i);
            }
            if (lose[i] == 1) {
                result[1].push_back(i);
            }
        }
        return result;
    }
};