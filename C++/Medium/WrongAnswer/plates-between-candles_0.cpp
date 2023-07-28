class Solution {
public:
    vector<int> platesBetweenCandles(string s, vector<vector<int>>& queries) {
        
        vector<int> ans;
        vector<int> candles;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '|')
                candles.push_back(i);
        }
        for (int i = 0; i < queries.size(); i++) {
            int left = queries[i][0], right = queries[i][1];
            int cnt = 0;
            for (int j = 0; j < candles.size(); j++) {
                if (candles[j] >= left && candles[j] <= right)
                    cnt++;
            }
            ans.push_back(cnt - 1);
        }
        return ans;
    }
};