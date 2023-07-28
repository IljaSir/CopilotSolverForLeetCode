class Solution {
public:
    int smallestChair(vector<vector<int>>& times, int targetFriend) {
        
        int n = times.size();
        vector<int> chairs(n);
        for (int i = 0; i < n; ++i) {
            chairs[i] = i;
        }
        sort(chairs.begin(), chairs.end(), [&](int a, int b) {
            return times[a][0] < times[b][0];
        });
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        int i = 0;
        for (int j = 0; j < n; ++j) {
            while (!pq.empty() && pq.top().first <= times[j][0]) {
                chairs[i++] = pq.top().second;
                pq.pop();
            }
            if (j == targetFriend) {
                return chairs[i];
            }
            pq.emplace(times[j][1], chairs[i++]);
        }
        return -1;
    }
};