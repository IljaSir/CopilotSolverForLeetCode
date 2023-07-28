class Solution {
public:
    int mostBooked(int n, vector<vector<int>>& meetings) {
        
        vector<int> rooms(n);
        for (auto& m : meetings) {
            rooms[m[0]] += 1;
            rooms[m[1]] -= 1;
        }
        int maxRoom = 0;
        int maxBooked = 0;
        int booked = 0;
        for (int i = 0; i < rooms.size(); ++i) {
            booked += rooms[i];
            if (booked > maxBooked) {
                maxRoom = i;
                maxBooked = booked;
            }
        }
        return maxRoom;
    }
};