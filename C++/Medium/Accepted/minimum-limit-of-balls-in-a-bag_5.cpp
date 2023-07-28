class Solution {
public:
    int minimumSize(vector<int>& nums, int maxOperations) {
        
        int l = 1, r = 1e9;
        while (l < r) {
            int m = (l + r) / 2;
            if (check(nums, m, maxOperations)) r = m;
            else l = m + 1;
        }
        return l;
    }
    bool check(vector<int>& nums, int m, int maxOperations) {
        for (int x : nums) {
            maxOperations -= (x - 1) / m;
            if (maxOperations < 0) return false;
        }
        return true;
    }
};