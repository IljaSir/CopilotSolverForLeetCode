class Solution {
public:
    int numSubmatrixSumTarget(vector<vector<int>>& matrix, int target) {
        
        int result = 0;
        for (int i = 0; i < matrix.size(); i++) {
            vector<int> sum(matrix[0].size(), 0);
            for (int j = i; j < matrix.size(); j++) {
                for (int k = 0; k < matrix[0].size(); k++) {
                    sum[k] += matrix[j][k];
                }
                result += subArraySum(sum, target);
            }
        }
        return result;
    }
    
    int subArraySum(vector<int>& nums, int k) {
        int result = 0;
        unordered_map<int, int> map;
        map[0] = 1;
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            result += map[sum - k];
            map[sum]++;
        }
        return result;
    }
};