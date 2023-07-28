class Solution {
public:
    bool carPooling(vector<vector<int>>& trips, int capacity) {
        
        int n = trips.size();
        vector<int> pos(1001, 0);
        for (int i = 0; i < n; i++) {
            pos[trips[i][1]] += trips[i][0];
            pos[trips[i][2]] -= trips[i][0];
        }
        for (int i = 0; i < 1001; i++) {
            capacity -= pos[i];
            if (capacity < 0) return false;
        }
        return true;
    }
};