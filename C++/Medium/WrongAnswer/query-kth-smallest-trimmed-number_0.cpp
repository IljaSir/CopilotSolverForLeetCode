class Solution {
public:
    vector<int> smallestTrimmedNumbers(vector<string>& nums, vector<vector<int>>& queries) {
        
        int n = nums.size();
        vector<int> ans;
        for (int i = 0; i < queries.size(); i++) {
            int k = queries[i][0];
            int trim = queries[i][1];
            vector<int> a;
            for (int j = 0; j < n; j++) {
                string s = nums[j].substr(0, trim);
                int x = stoi(s);
                a.push_back(x);
            }
            sort(a.begin(), a.end());
            ans.push_back(a[k-1]);
        }
        return ans;
    }
};