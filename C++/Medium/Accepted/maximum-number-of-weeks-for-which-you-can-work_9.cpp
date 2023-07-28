class Solution {
public:
    long long numberOfWeeks(vector<int>& milestones) {
        
        long long sum = 0;
        int max = 0;
        for(auto &n:milestones){
            sum += n;
            if(n > max) max = n;
        }
        long long ans = sum - max;
        if(ans >= max){
            return sum;
        }else{
            return 2 * ans + 1;
        }
    }
};