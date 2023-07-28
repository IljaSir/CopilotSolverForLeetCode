class Solution {
public:
    vector<int> findKDistantIndices(vector<int>& nums, int key, int k) {
        
        vector<int> result;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == key) {
                result.push_back(i);
            }
        }
        int start = 0;
        int end = 0;
        vector<int> finalResult;
        while (end < result.size()) {
            if (result[end] - result[start] <= k) {
                finalResult.push_back(result[end]);
                end++;
            } else {
                start++;
            }
        }
        return finalResult;
    }
};