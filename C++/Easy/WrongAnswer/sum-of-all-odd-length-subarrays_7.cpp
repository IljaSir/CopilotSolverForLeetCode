class Solution {
public:
    int sumOddLengthSubarrays(vector<int>& arr) {
        
        int sum = 0;
        for(int i = 0; i < arr.size(); i++){
            int temp = 0;
            for(int j = 0; j < arr.size()-i; j++){
                temp += arr[i+j];
                if((i+1)%2 == 1){
                    sum += temp;
                }
            }
        }
        return sum;
    }
};