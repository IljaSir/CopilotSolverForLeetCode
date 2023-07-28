class Solution {
public:
    vector<int> maximumBeauty(vector<vector<int>>& items, vector<int>& queries) {
        
        vector<int> ans;
        sort(items.begin(), items.end());
        for (int query : queries) {
            int maxBeauty = 0;
            for (auto& item : items) {
                if (item[0] > query) break;
                maxBeauty = max(maxBeauty, item[1]);
            }
            ans.push_back(maxBeauty);
        }
        return ans;
    }
};