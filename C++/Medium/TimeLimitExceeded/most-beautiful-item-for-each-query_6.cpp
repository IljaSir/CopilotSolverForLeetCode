class Solution {
public:
    vector<int> maximumBeauty(vector<vector<int>>& items, vector<int>& queries) {
        
        vector<int> answer;
        sort(items.begin(), items.end(), [](vector<int>& a, vector<int>& b){return a[1] > b[1];});
        for (int i = 0; i < queries.size(); ++i) {
            int maxBeauty = 0;
            int price = queries[i];
            for (int j = 0; j < items.size(); ++j) {
                if (items[j][0] <= price) {
                    maxBeauty = max(maxBeauty, items[j][1]);
                }
            }
            answer.push_back(maxBeauty);
        }
        return answer;
    }
};