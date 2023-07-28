class Solution {
public:
    vector<int> finalPrices(vector<int>& prices) {
        
        int n = prices.size();
        vector<int> ans;
        for(int i = 0; i < n; i++){
            int j = i + 1;
            while(j < n && prices[j] > prices[i]){
                j++;
            }
            if(j < n){
                ans.push_back(prices[i] - prices[j]);
            }else{
                ans.push_back(prices[i]);
            }
        }
        return ans;
    }
};