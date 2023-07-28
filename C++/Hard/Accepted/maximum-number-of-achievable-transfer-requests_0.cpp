class Solution {
public:
    int maximumRequests(int n, vector<vector<int>>& requests) {
        
        int max = 0;
        for (int i = 0; i < (1 << requests.size()); i++) {
            int count = 0;
            vector<int> buildings(n, 0);
            for (int j = 0; j < requests.size(); j++) {
                if (i & (1 << j)) {
                    buildings[requests[j][0]]--;
                    buildings[requests[j][1]]++;
                    count++;
                }
            }
            bool flag = true;
            for (int j = 0; j < buildings.size(); j++) {
                if (buildings[j] != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag && count > max) {
                max = count;
            }
        }
        return max;
    }
};