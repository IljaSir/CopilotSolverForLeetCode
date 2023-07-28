class Solution {
public:
    int smallestChair(vector<vector<int>>& times, int targetFriend) {
        
        int n = times.size();
        vector<int> chair(n, -1);
        vector<int> friendId(n, -1);
        vector<int> arrival(n, 0);
        vector<int> leave(n, 0);
        for (int i = 0; i < n; i++) {
            arrival[i] = times[i][0];
            leave[i] = times[i][1];
            friendId[i] = i;
        }
        sort(friendId.begin(), friendId.end(), [&](int a, int b) {
            return arrival[a] < arrival[b];
        });
        sort(arrival.begin(), arrival.end());
        sort(leave.begin(), leave.end());
        multiset<int> chairs;
        for (int i = 0; i < n; i++) {
            chairs.insert(i);
        }
        for (int i = 0, j = 0; i < n; i++) {
            int id = friendId[i];
            while (j < n && leave[j] <= arrival[id]) {
                chairs.insert(chair[j]);
                j++;
            }
            chair[id] = *chairs.begin();
            chairs.erase(chairs.begin());
            if (id == targetFriend) {
                return chair[id];
            }
        }
        return -1;
    }
};