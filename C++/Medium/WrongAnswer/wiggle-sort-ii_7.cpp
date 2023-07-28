class Solution {
public:
    void wiggleSort(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> sortedNums = nums;
        sort(sortedNums.begin(), sortedNums.end());
        int i = n - 1;
        int j = 1;
        int k = 0;
        while (k < n) {
            if (k % 2 == 0) {
                nums[k] = sortedNums[i];
                i--;
            } else {
                nums[k] = sortedNums[j];
                j++;
            }
            k++;
        }
    }
};