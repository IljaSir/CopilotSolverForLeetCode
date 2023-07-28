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
                if (diff < 0) break;
                clone[j] = diff;
            }
            if (j == needs.size()) {
                res = min(res, s.back() + dp(price, special, clone));
            }
        }
        return res;
    }
    int dot(vector<int>& a, vector<int>& b) {
        int sum = 0;
        for (int i = 0; i < a.size(); ++i) {
            sum += a[i] * b[i];
        }
        return sum;
    }
};