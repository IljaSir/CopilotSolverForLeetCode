class Solution {
public:
    int maxDistToClosest(vector<int>& seats) {
        
        int n = seats.size();
        int maxDistance = 1;
        int lastOne = -1;
        for(int i = 0; i < n; i++){
            if(seats[i] == 1){
                if(lastOne == -1){
                    maxDistance = i;
                }else{
                    maxDistance = max(maxDistance, (i - lastOne) / 2);
                }
                lastOne = i;
            }
        }
        return max(maxDistance, n - 1 - lastOne);
    }
};