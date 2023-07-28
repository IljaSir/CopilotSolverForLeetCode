class Solution {
public:
    int findMaxK(vector<int>& nums) {
        
        int maxK = -1;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] > 0) {
                if (nums[i] > maxK) {
                    maxK = nums[i];
                }
            }
        }
        return maxK;
    }
    int findMinK(vector<int>& nums) {
        int minK = INT_MAX;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] < 0) {
                if (nums[i] < minK) {
                    minK = nums[i];
                }
            }
        }
        return minK;
    }
    bool findK(vector<int>& nums, int k) {
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == k) {
                return true;
            }
        }
        return false;
    }
    int findKthPositive(vector<int>& arr, int k) {
        int maxK = findMaxK(arr);
        int minK = findMinK(arr);
        int maxK1 = abs(minK);
        if (maxK1 > maxK) {
            maxK = maxK1;
        }
        int count = 0;
        for (int i = 1; i <= maxK; i++) {
            if (findK(arr, i)) {
                count++;
            } else if (findK(arr, -i)) {
                count++;
            }
        }
        if (count >= k) {
            return k;
        } else {
            return -1;
        }
    }
};