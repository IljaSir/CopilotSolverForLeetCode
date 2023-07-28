class Solution {
public:
    int maxConsecutive(int bottom, int top, vector<int>& special) {
        
        int max = 0;
        int count = 0;
        int i = 0;
        int j = 0;
        sort(special.begin(), special.end());
        for(i = bottom; i <= top; i++){
            if(j < special.size() && special[j] == i){
                count = 0;
                j++;
            }else{
                count++;
                if(count > max){
                    max = count;
                }
            }
        }
        return max;
    }
};