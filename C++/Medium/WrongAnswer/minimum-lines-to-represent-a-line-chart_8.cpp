class Solution {
public:
    int minimumLines(vector<vector<int>>& stockPrices) {
        
        int n = stockPrices.size();
        if(n==1)
            return 1;
        int count = 1;
        int i = 0;
        while(i<n-1){
            if(stockPrices[i][1] > stockPrices[i+1][1]){
                count++;
                i++;
            }
            else{
                int j = i+1;
                while(j<n-1 && stockPrices[j][1] <= stockPrices[j+1][1]){
                    j++;
                }
                count++;
                i = j+1;
            }
        }
        return count;
    }
};