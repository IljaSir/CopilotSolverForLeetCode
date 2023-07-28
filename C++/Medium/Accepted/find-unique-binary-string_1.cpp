class Solution {
public:
    string findDifferentBinaryString(vector<string>& nums) {
        
        int n = nums.size();
        unordered_set<int> st;
        for (int i = 0; i < n; ++i) {
            int val = 0;
            for (int j = 0; j < n; ++j) {
                val = val * 2 + nums[i][j] - '0';
            }
            st.insert(val);
        }
        int val = 0;
        for (int i = 0; i < n; ++i) {
            val = val * 2 + 1;
        }
        for (int i = 0; i < n; ++i) {
            if (st.find(i) == st.end()) {
                val = i;
                break;
            }
        }
        string ans;
        while (val > 0) {
            ans = char('0' + val % 2) + ans;
            val /= 2;
        }
        while (ans.size() < n) {
            ans = '0' + ans;
        }
        return ans;
    }
};