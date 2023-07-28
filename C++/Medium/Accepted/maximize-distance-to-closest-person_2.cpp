class Solution {
public:
    int maxDistToClosest(vector<int>& seats) {
        
        int n = seats.size();
        int left = -1;
        int right = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                left = i;
            } else {
                while (right < n && seats[right] == 0 || right < i) {
                    right++;
                }
                int l = left == -1 ? n : i - left;
                int r = right == n ? n : right - i;
                ans = max(ans, min(l, r));
            }
        }
        return ans;
    }
};