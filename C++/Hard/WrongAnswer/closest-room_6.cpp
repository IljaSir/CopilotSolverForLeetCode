class Solution {
public:
    vector<int> closestRoom(vector<vector<int>>& rooms, vector<vector<int>>& queries) {
        
        int n = rooms.size();
        vector<int> res(queries.size(), -1);
        vector<int> order(queries.size());
        for (int i = 0; i < queries.size(); i++) {
            order[i] = i;
        }
        sort(order.begin(), order.end(), [&](int a, int b) {
            return queries[a][1] > queries[b][1];
        });
        sort(rooms.begin(), rooms.end(), [&](vector<int> a, vector<int> b) {
            return a[1] > b[1];
        });
        int j = 0;
        for (int i = 0; i < queries.size(); i++) {
            int idx = order[i];
            while (j < n && rooms[j][1] >= queries[idx][1]) {
                rooms[j][1] = j;
                j++;
            }
            if (j == 0) {
                continue;
            }
            int left = 0;
            int right = j - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (rooms[mid][0] < queries[idx][0]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (abs(rooms[left][0] - queries[idx][0]) < abs(res[idx] - queries[idx][0])) {
                res[idx] = rooms[left][0];
            }
            if (left > 0 && abs(rooms[left - 1][0] - queries[idx][0]) < abs(res[idx] - queries[idx][0])) {
                res[idx] = rooms[left - 1][0];
            }
        }
        return res;
    }
};