class Solution {
public:
    vector<int> finalPrices(vector<int>& prices) {
        
        int size = prices.size();
        vector<int> result(size);
        for(int i = 0; i < size; i++) {
            result[i] = prices[i];
            for(int j = i + 1; j < size; j++) {
                if(prices[j] <= prices[i]) {
                    result[i] -= prices[j];
                    break;
                }
            }
        }
        return result;
    }
};