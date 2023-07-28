class Solution {
public:
    vector<int> answerQueries(vector<int>& nums, vector<int>& queries) {
        
        vector<int> ans;
        for (int q: queries) {
            int count = 0;
            for (int i = 0; i < nums.size(); i++) {
                if (nums[i] <= q) {
                    count++;
                    q -= nums[i];
                }
            }
            ans.push_back(count);
        }
        return ans;
    }
};