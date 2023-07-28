class Solution {
public:
    int minimumDeletions(vector<int>& nums) {
        
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        int left = 0;
        int right = nums.size() - 1;
        int count = 0;
        while (left < minIndex && right > maxIndex) {
            left++;
            right--;
            count++;
        }
        while (left < minIndex) {
            left++;
            count++;
        }
        while (right > maxIndex) {
            right--;
            count++;
        }
        return count;
    }
};