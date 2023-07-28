class Solution {
public:
    int minimumSize(vector<int>& nums, int maxOperations) {
        
        int l = 1, r = 1e9, mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            int cnt = 0;
            for (int x : nums)
                cnt += (x - 1) / mid;
            if (cnt > maxOperations)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
};