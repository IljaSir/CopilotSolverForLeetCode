class Solution {
public:
    int smallestChair(vector<vector<int>>& times, int targetFriend) {
        
        // sort by arrival time
        sort(times.begin(), times.end(), [](const auto& a, const auto& b) {
            return a[0] < b[0];
        });
        // sort by leaving time
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> minHeap;
        // all chairs are available
        for (int i = 0; i < times.size(); i++) {
            minHeap.push({times[i][1], i});
        }
        // chair 0 is occupied
        vector<int> chairs(times.size(), 0);
        chairs[0] = 1;
        int chair = 0;
        for (int i = 0; i < times.size(); i++) {
            // free the chairs
            while (!minHeap.empty() && minHeap.top().first <= times[i][0]) {
                auto [leaving, index] = minHeap.top();
                minHeap.pop();
                chairs[index] = 0;
            }
            // find the smallest unoccupied chair
            for (int j = 0; j < chairs.size(); j++) {
                if (chairs[j] == 0) {
                    chair = j;
                    chairs[j] = 1;
                    break;
                }
            }
            if (i == targetFriend) {
                break;
            }
        }
        return chair;
    }
};