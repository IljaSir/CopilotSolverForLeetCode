class Solution {
public:
    int findCrossingTime(int n, int k, vector<vector<int>>& time) {
        
        // leftToRighti + rightToLefti > leftToRightj + rightToLeftj
        // leftToRighti + rightToLefti == leftToRightj + rightToLeftj and i > j
        vector<vector<int>> workers;
        for (int i = 0; i < k; ++i) {
            workers.push_back({time[i][0] + time[i][2], i});
        }
        sort(workers.begin(), workers.end());
        int left = 0, right = 0;
        int oldWarehouse = n, newWarehouse = 0;
        int res = 0;
        while (oldWarehouse > 0) {
            if (left < k) {
                int worker = workers[left][1];
                res = max(res, time[worker][0]);
                res += time[worker][1];
                oldWarehouse--;
                newWarehouse++;
                left++;
                right++;
            } else {
                int worker = workers[right][1];
                res += time[worker][2];
                res += time[worker][3];
                oldWarehouse--;
                newWarehouse++;
                right++;
            }
        }
        return res;
    }
};