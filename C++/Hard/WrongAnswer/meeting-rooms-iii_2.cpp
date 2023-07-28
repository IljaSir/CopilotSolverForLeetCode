class Solution {
public:
    int mostBooked(int n, vector<vector<int>>& meetings) {
        
        vector<int> rooms(n, 0);
        for (auto& meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            for (int i = 0; i < n; ++i) {
                if (rooms[i] <= start) {
                    rooms[i] = end;
                    break;
                }
            }
        }
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < n; ++i) {
            int count = 0;
            for (auto& meeting : meetings) {
                if (meeting[0] >= rooms[i]) {
                    ++count;
                }
            }
            if (count > max) {
                max = count;
                maxIndex = i;
            }
        }
        return maxIndex;
    }
};