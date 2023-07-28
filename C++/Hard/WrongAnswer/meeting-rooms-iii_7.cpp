class Solution {
public:
    int mostBooked(int n, vector<vector<int>>& meetings) {
        
        vector<int> times(500001, 0);
        for (auto& meeting : meetings) {
            times[meeting[0]]++;
            times[meeting[1]]--;
        }
        int maxCount = 0, maxRoom = 0, curCount = 0;
        for (int i = 0; i < times.size(); i++) {
            curCount += times[i];
            if (curCount > maxCount) {
                maxCount = curCount;
                maxRoom = i;
            }
        }
        return maxRoom;
    }
};