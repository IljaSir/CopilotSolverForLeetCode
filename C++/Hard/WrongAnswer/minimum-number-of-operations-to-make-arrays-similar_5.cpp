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
        int n = nums.size();
        int m = target.size();
        if (n == 1 && m == 1) {
            return nums[0] == target[0] ? 0 : 1;
        }
        long long diff = makeSimilar(nums, target);
        if (diff % 2 == 1) {
            return -1;
        }
        vector<int> nums1, nums2, target1, target2;
        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                nums1.push_back(nums[i]);
            } else {
                nums2.push_back(nums[i]);
            }
        }
        for (int i = 0; i < m; i++) {
            if (i < m / 2) {
                target1.push_back(target[i]);
            } else {
                target2.push_back(target[i]);
            }
        }
        long long diff1 = makeSimilar(nums1, target1);
        long long diff2 = makeSimilar(nums2, target2);
        if (diff1 > diff2) {
            swap(diff1, diff2);
            swap(nums1, nums2);
            swap(target1, target2);
        }
        if (diff1 == diff2) {
            return 2;
        }
        long long diff3 = makeSimilar(nums1, target2);
        long long diff4 = makeSimilar(nums2, target1);
        if (diff3 > diff4) {
            swap(diff3, diff4);
            swap(nums1, nums2);
            swap(target1, target2);
        }
        if (diff3 == diff4) {
            return 2;
        }
        if (diff1 + diff4 == diff) {
            return 1;
        }
        if (diff2 + diff3 == diff) {
            return 1;
        }
        if (diff1 + diff3 == diff) {
            return 2;
        }
        if (diff2 + diff4 == diff) {
            return 2;
        }
        return -1;
    }
};