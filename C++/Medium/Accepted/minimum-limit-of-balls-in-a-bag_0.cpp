class Solution {
public:
    int minimumSize(vector<int>& nums, int maxOperations) {
        
        int l = 1, r = 1e9;
        while (l < r) {
            int m = (l + r) / 2;
            int cnt = 0;
            for (int x : nums) {
                cnt += (x - 1) / m;
            }
            if (cnt <= maxOperations) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
};