class Solution {
public:
    int numOfWays(vector<int>& nums) {
        
        int n = nums.size();
        if (n <= 2) return 1;
        int root = nums[0];
        vector<int> left, right;
        for (int i = 1; i < n; ++i) {
            if (nums[i] < root) left.push_back(nums[i]);
            else right.push_back(nums[i]);
        }
        long long res = (long long)numOfWays(left) * numOfWays(right) % 1000000007;
        for (int i = 1; i < n; ++i) {
            if (nums[i] > root) break;
            left.push_back(nums[i]);
            right.erase(find(right.begin(), right.end(), nums[i]));
            res = (res + (long long)numOfWays(left) * numOfWays(right)) % 1000000007;
        }
        return res;
    }
};