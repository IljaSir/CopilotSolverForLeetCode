class Solution {
public:
    int maxDistToClosest(vector<int>& seats) {
        
        int res = 0;
        int n = seats.size();
        int prev = -1;
        for(int i = 0; i < n; i++){
            if(seats[i] == 1){
                if(prev == -1){
                    res = i;
                }else{
                    res = max(res, (i - prev) / 2);
                }
                prev = i;
            }
        }
        return max(res, n - 1 - prev);
    }
};