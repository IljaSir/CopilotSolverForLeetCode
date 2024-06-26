class Solution {
public:
    int maxDistToClosest(vector<int>& seats) {
        
        int n = seats.size();
        int res = 0;
        int last = -1;
        for (int i = 0; i < n; ++i) {
            if (seats[i] == 1) {
                res = last < 0 ? i : max(res, (i - last) / 2);
                last = i;
            }
        }
        res = max(res, n - last - 1);
        return res;
    }
};