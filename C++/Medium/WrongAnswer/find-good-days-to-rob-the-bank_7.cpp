class Solution {
public:
    vector<int> goodDaysToRobBank(vector<int>& security, int time) {
        
        vector<int> res;
        int n = security.size();
        vector<int> maxBefore(n, 0);
        vector<int> minAfter(n, 0);
        for(int i = 0; i < n; i++){
            if(i == 0){
                maxBefore[i] = security[i];
            }else{
                maxBefore[i] = max(maxBefore[i - 1], security[i]);
            }
        }
        for(int i = n - 1; i >= 0; i--){
            if(i == n - 1){
                minAfter[i] = security[i];
            }else{
                minAfter[i] = min(minAfter[i + 1], security[i]);
            }
        }
        for(int i = 0; i < n; i++){
            if(i - time >= 0 && i + time < n){
                if(maxBefore[i - time] >= minAfter[i + time]){
                    res.push_back(i);
                }
            }else if(i - time < 0 && i + time < n){
                if(maxBefore[0] >= minAfter[i + time]){
                    res.push_back(i);
                }
            }else if(i - time >= 0 && i + time >= n){
                if(maxBefore[i - time] >= minAfter[n - 1]){
                    res.push_back(i);
                }
            }else{
                if(maxBefore[0] >= minAfter[n - 1]){
                    res.push_back(i);
                }
            }
        }
        return res;
    }
};