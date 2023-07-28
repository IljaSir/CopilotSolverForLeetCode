class Solution {
public:
    bool isCovered(vector<vector<int>>& ranges, int left, int right) {
        
        vector<int> vec(52, 0);
        for(auto &range : ranges){
            vec[range[0]]++;
            vec[range[1]+1]--;
        }
        int sum = 0;
        for(int i = 1; i < 52; i++){
            sum += vec[i];
            if(i >= left && i <= right && sum <= 0){
                return false;
            }
        }
        return true;
    }
};