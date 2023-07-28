class Solution {
public:
    int maximizeWin(vector<int>& prizePositions, int k) {
        
        int n = prizePositions.size();
        vector<int> pre(n, 0);
        int res = 0;
        for(int i = 0; i < n; i++){
            if(i == 0) pre[i] = 1;
            else if(prizePositions[i] - prizePositions[i-1] <= k) pre[i] = pre[i-1] + 1;
            else pre[i] = 1;
            res = max(res, pre[i]);
        }
        for(int i = n-1; i >= 0; i--){
            if(i == n-1) pre[i] = 1;
            else if(prizePositions[i+1] - prizePositions[i] <= k) pre[i] = pre[i+1] + 1;
            else pre[i] = 1;
            res = max(res, pre[i]);
        }
        for(int i = 1; i < n-1; i++){
            if(prizePositions[i+1] - prizePositions[i-1] <= k) res = max(res, pre[i-1] + pre[i+1] + 1);
        }
        return res;
    }
};