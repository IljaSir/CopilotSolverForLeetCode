class Solution {
public:
    int minRefuelStops(int target, int startFuel, vector<vector<int>>& stations) {
        
        int cur = startFuel;
        int index = 0;
        int count = 0;
        while (cur < target) {
            int max = 0;
            int maxIndex = -1;
            for (int i = index; i < stations.size(); i++) {
                if (stations[i][0] > cur) break;
                if (stations[i][1] > max) {
                    max = stations[i][1];
                    maxIndex = i;
                }
            }
            if (max == 0) return -1;
            count++;
            cur += max;
            index = maxIndex + 1;
        }
        return count;
    }
};