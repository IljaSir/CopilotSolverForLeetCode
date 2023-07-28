class Solution {
public:
    long long makeSimilar(vector<int>& nums, vector<int>& target) {
        
        long long sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i] - target[i];
        }
        return sum;
    }
    int minOperations(vector<int>& nums, vector<int>& target) {
        int n = nums.size();
        int m = target.size();
        long long sum = makeSimilar(nums, target);
        if (sum == 0) {
            return 0;
        }
        if (sum < 0) {
            sum = -sum;
            swap(nums, target);
        }
        vector<int> a1, a2;
        for (int i = 0; i < n; i++) {
            a1.push_back(nums[i] - target[i]);
        }
        for (int i = 0; i < m; i++) {
            a2.push_back(target[i] - nums[i]);
        }
        sort(a1.begin(), a1.end());
        sort(a2.begin(), a2.end());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int j = upper_bound(a2.begin(), a2.end(), a1[i]) - a2.begin();
            sum -= a1[i];
            ans++;
            if (sum <= 0) {
                return ans;
            }
            if (j > 0) {
                sum -= a2[j - 1];
                ans++;
                if (sum <= 0) {
                    return ans;
                }
            }
        }
        return ans;
    }
};