class Solution {
public:
    bool isCovered(vector<vector<int>>& ranges, int left, int right) {
        
        vector<int> v(52,0);
        for(auto r:ranges){
            v[r[0]]++;
            v[r[1]+1]--;
        }
        int sum = 0;
        for(int i = 1;i<=50;i++){
            sum += v[i];
            if(i>=left && i<=right && sum<=0) return false;
        }
        return true;
    }
};