class Solution {
public:
    int distinctAverages(vector<int>& nums) {
        
        unordered_set<double> st;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                st.insert((double)(nums[i] + nums[j]) / 2);
            }
        }
        return st.size();
    }
};