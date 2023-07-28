class Solution {
public:
    int minimumSize(vector<int>& nums, int maxOperations) {
        
        int left = 1, right = 1e9;
        while (left < right) {
            int mid = (left + right) / 2;
            int ops = 0;
            for (int n : nums) {
                ops += (n - 1) / mid;
            }
            if (ops <= maxOperations) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
};