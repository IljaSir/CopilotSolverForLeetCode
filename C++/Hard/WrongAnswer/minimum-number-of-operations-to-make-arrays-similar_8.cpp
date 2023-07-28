class Solution {
public:
    long long makeSimilar(vector<int>& nums, vector<int>& target) {
        
        long long res = 0;
        for (int i = 0; i < nums.size(); i++) {
            res += abs(nums[i] - target[i]);
        }
        return res;
    }
    int minOperations(vector<int>& nums, vector<int>& target) {
        long long sum1 = accumulate(nums.begin(), nums.end(), 0);
        long long sum2 = accumulate(target.begin(), target.end(), 0);
        long long diff = sum2 - sum1;
        if (diff % 2 != 0) {
            return -1;
        }
        diff /= 2;
        vector<int> nums1;
        vector<int> nums2;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] > target[i]) {
                nums1.push_back(nums[i] - target[i]);
            } else {
                nums2.push_back(target[i] - nums[i]);
            }
        }
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        long long res1 = makeSimilar(nums1, nums2);
        if (res1 <= diff) {
            return nums1.size() + nums2.size();
        }
        int res = INT_MAX;
        int i = 0;
        int j = nums2.size() - 1;
        long long sum = 0;
        while (i < nums1.size()) {
            sum += nums1[i];
            while (j >= 0 && sum + nums2[j] > diff) {
                sum -= nums2[j];
                j--;
            }
            if (sum == diff) {
                res = min(res, i + 1 + (int)nums2.size() - j - 1);
            }
            i++;
        }
        return res == INT_MAX ? -1 : res;
    }
};