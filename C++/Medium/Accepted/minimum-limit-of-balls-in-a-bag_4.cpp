class Solution {
public:
    int minimumSize(vector<int>& nums, int maxOperations) {
        
        int l = 1, r = 1e9;
        while (l < r) {
            int mid = (l + r) / 2;
            int ops = 0;
            for (int n : nums) ops += (n - 1) / mid;
            if (ops <= maxOperations) r = mid;
            else l = mid + 1;
        }
        return l;
    }
};