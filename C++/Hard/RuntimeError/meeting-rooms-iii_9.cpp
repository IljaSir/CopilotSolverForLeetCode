class Solution {
public:
    int mostBooked(int n, vector<vector<int>>& meetings) {
        
        vector<int> rooms(n, 0);
        for (auto meeting: meetings) {
            rooms[meeting[0]]++;
            rooms[meeting[1]]--;
        }
        int maxCount = rooms[0], maxIndex = 0;
        for (int i = 1; i < n; i++) {
            rooms[i] += rooms[i - 1];
            if (rooms[i] > maxCount) {
                maxCount = rooms[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
};