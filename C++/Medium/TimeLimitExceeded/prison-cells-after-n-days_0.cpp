class Solution {
public:
    vector<int> prisonAfterNDays(vector<int>& cells, int n) {
        
        vector<int> ans(8, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < 7; j++) {
                ans[j] = cells[j - 1] == cells[j + 1];
            }
            cells = ans;
        }
        return ans;
    }
};