class Solution {
public:
    int findSmallestInteger(vector<int>& nums, int value) {
        
        vector<int> arr;
        for (int i = 0; i < nums.size(); i++) {
            arr.push_back(nums[i] + value);
            arr.push_back(nums[i] - value);
        }
        sort(arr.begin(), arr.end());
        int res = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr[i] < res) continue;
            if (arr[i] > res) break;
            res++;
        }
        return res;
    }
};