class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        
        int len = nums.size();
        if (len <= 1) return;
        k = k % len;
        if (k == 0) return;
        int i = 0;
        int j = len - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        i = 0;
        j = k - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        i = k;
        j = len - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
};