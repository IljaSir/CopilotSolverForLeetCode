class Solution {
public:
    int sumOddLengthSubarrays(vector<int>& arr) {
        
        int sum = 0;
        for(int i = 0; i < arr.size(); i++){
            int start = i, end = i;
            while(start >= 0){
                for(int k = start; k <= end; k++){
                    sum += arr[k];
                }
                start--;
                end++;
            }
        }
        return sum;
    }
};