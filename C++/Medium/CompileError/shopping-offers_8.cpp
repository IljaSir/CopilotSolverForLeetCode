class Solution {
public:
    int shoppingOffers(vector<int>& price, vector<vector<int>>& special, vector<int>& needs) {
        
        return dp(price, special, needs);
    }
    int dp(vector<int>& price, vector<vector<int>>& special, vector<int>& needs) {
        int res = dot(needs, price);
        for (auto& s : special) {
            vector<int> clone = needs;
            int j = 0;
            for (; j < needs.size(); ++j) {
                int diff = clone[j] - s[j];
                if (d;
    }
};