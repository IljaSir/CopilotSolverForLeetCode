class Solution {
public:
    int maxDistToClosest(vector<int>& seats) {
        
        int n = seats.size();
        int max_dist = 0;
        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                if (prev == -1) {
                    max_dist = max(max_dist, i);
                } else {
                    max_dist = max(max_dist, (i - prev) / 2);
                }
                prev = i;
            }
        }
        max_dist = max(max_dist, n - 1 - prev);
        return max_dist;
    }
};