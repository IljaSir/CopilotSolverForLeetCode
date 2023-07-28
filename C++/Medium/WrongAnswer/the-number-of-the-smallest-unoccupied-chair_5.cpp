class Solution {
public:
    int smallestChair(vector<vector<int>>& times, int targetFriend) {
        
        int n = times.size();
        vector<int> chairs(n, -1);
        vector<int> friends(n, -1);
        for (int i = 0; i < n; ++i) {
            friends[i] = i;
        }
        sort(friends.begin(), friends.end(), [&](int a, int b) { return times[a][0] < times[b][0]; });
        sort(times.begin(), times.end());
        int i = 0;
        for (int t = 0; i < n; ++t) {
            while (i < n && times[friends[i]][0] <= t) {
                int f = friends[i];
                int j = 0;
                while (chairs[j] != -1 && chairs[j] <= t) {
                    ++j;
                }
                chairs[j] = times[f][1];
                if (f == targetFriend) {
                    return j;
                }
                ++i;
            }
        }
        return -1;
    }
};