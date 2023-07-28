class Solution {
public:
    int minMoves(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> pos;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) pos.push_back(i);
        }
        vector<int> prefix = {0};
        for (int i = 0; i < pos.size(); ++i) {
            prefix.push_back(prefix.back() + pos[i]);
        }
        int res = 0x3f3f3f3f;
        for (int i = 0; i + k - 1 < pos.size(); ++i) {
            int mid = (i + i + k - 1) / 2;
            int cur = (pos[mid] * (mid - i) - (prefix[mid] - prefix[i])) + (prefix[i + k] - prefix[mid + 1] - pos[mid] * (i + k - mid - 1));
            res = min(res, cur);
        }
        return res;
    }
};