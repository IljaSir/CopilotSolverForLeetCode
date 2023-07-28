class Solution {
public:
    int minRefuelStops(int target, int startFuel, vector<vector<int>>& stations) {
        
        priority_queue<int> pq;
        int N = stations.size();
        int i = 0;
        int res = 0;
        int cur = startFuel;
        while (cur < target) {
            while (i < N && stations[i][0] <= cur) {
                pq.push(stations[i][1]);
                i++;
            }
            if (pq.empty()) {
                return -1;
            }
            cur += pq.top();
            pq.pop();
            res++;
        }
        return res;
    }
};