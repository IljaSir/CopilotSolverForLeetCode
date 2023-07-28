class Solution {
public:
    int minSwaps(vector<int>& nums) {
        
        int n = nums.size();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
            }
        }
        int k = count;
        int i = 0;
        int j = 0;
        int maxCount = 0;
        while (j < n) {
            if (nums[j] == 1) {
                count--;
            }
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                maxCount = max(maxCount, k - count);
                if (nums[i] == 1) {
                    count++;
                }
                i++;
                j++;
            }
        }
        return k - maxCount;
    }
};