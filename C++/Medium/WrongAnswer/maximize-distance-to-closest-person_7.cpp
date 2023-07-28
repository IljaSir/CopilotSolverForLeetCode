class Solution {
public:
    int maxDistToClosest(vector<int>& seats) {
        
        int n = seats.size();
        int maxDist = 0;
        int start = -1, end = -1;
        for (int i = 0; i < n; ++i) {
            if (seats[i] == 1) {
                if (start == -1) {
                    start = i;
                } else {
                    end = i;
                    maxDist = max(maxDist, (end - start) / 2);
                    start = end;
                }
            }
        }
        maxDist = max(maxDist, n - start - 1);
        maxDist = max(maxDist, start);
        return maxDist;
    }
};