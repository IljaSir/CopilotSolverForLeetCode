class Solution {
public:
    void wiggleSort(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> temp = nums;
        sort(temp.begin(), temp.end());
        int i = n - 1, j = 1;
        while (i >= 0) {
            nums[j] = temp[i];
            i -= 2;
            j += 2;
        }
        i = n - 2;
        j = 0;
        while (i >= 0) {
            nums[j] = temp[i];
            i -= 2;
            j += 2;
        }
    }
};