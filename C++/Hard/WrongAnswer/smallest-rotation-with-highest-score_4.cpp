class Solution {
public:
    int bestRotation(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> changes(n, 0);
        for (int i = 0; i < n; ++i) {
            int left = (i - nums[i] + 1 + n) % n;
            int right = (i + 1) % n;
            --changes[left];
            ++changes[right];
            if (left > right) {
                --changes[0];
            }
        }
        int best = 0;
        int bestIdx = 0;
        int curr = 0;
        for (int i = 0; i < n; ++i) {
            curr += changes[i];
            if (curr > best) {
                best = curr;
                bestIdx = i;
            }
        }
        return bestIdx;
    }
};