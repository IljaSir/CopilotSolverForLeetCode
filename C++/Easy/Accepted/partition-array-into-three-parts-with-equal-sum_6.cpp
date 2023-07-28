class Solution {
public:
    bool canThreePartsEqualSum(vector<int>& arr) {
        
        int sum = 0;
        for(int i = 0; i < arr.size(); i++){
            sum += arr[i];
        }
        if(sum % 3 != 0){
            return false;
        }
        int target = sum / 3;
        int curSum = 0;
        int count = 0;
        for(int i = 0; i < arr.size(); i++){
            curSum += arr[i];
            if(curSum == target){
                count++;
                curSum = 0;
            }
        }
        return count >= 3;
    }
};