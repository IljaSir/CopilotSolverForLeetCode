class Solution {
public:
    long long makeSimilar(vector<int>& nums, vector<int>& target) {
        
        long long ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            ans += abs(nums[i] - target[i]);
        }
        return ans;
    }
    int minOperations(vector<int>& nums, vector<int>& target) {
        long long sum1 = accumulate(nums.begin(), nums.end(), 0LL);
        long long sum2 = accumulate(target.begin(), target.end(), 0LL);
        long long diff = (sum1 - sum2) / 2;
        if (diff < 0) {
            swap(nums, target);
            diff = -diff;
        }
        sort(nums.begin(), nums.end());
        sort(target.begin(), target.end());
        long long ans = 0;
        for (int i = nums.size() - 1, j = target.size() - 1; i >= 0; i--) {
            while (j >= 0 && nums[i] - target[j] > diff) {
                j--;
            }
            if (j >= 0 && nums[i] - target[j] == diff) {
                ans++;
                j--;
            }
        }
        return nums.size() - ans;
    }
};