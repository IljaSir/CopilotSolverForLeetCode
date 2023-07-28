class Solution {
public:
    int numPairsDivisibleBy60(vector<int>& time) {
        
        int count = 0;
        int i,j;
        for(i=0;i<time.size();i++){
            for(j=i+1;j<time.size();j++){
                if((time[i]+time[j])%60==0){
                    count++;
                }
            }
        }
        return count;
    }
};