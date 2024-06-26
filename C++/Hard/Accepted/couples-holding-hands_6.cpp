class Solution {
public:
    int minSwapsCouples(vector<int>& row) {
        
        int n = row.size();
        int ans = 0;
        vector<int> pos(n);
        for (int i = 0; i < n; i++) {
            pos[row[i]] = i;
        }
        for (int i = 0; i < n; i += 2) {
            int x = row[i];
            int y = x ^ 1;
            if (row[i + 1] == y) {
                continue;
            }
            ans++;
            int pos_y = pos[y];
            swap(row[i + 1], row[pos_y]);
            pos[row[i + 1]] = i + 1;
            pos[row[pos_y]] = pos_y;
        }
        return ans;
    }
};