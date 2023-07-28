class Solution {
public:
    int minMoves(vector<int>& nums, int k) {
        
        vector<int> ones;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == 1) {
                ones.push_back(i);
            }
        }
        int res = INT_MAX;
        int n = ones.size();
        int mid = n / 2;
        for (int i = 0; i < n - k + 1; i++) {
            int j = i + k - 1;
            int left = ones[i + mid - i];
            int right = ones[j - mid + j];
            res = min(res, (right - left) - (j - i) + (mid - i));
        }
        return res;
    }
};