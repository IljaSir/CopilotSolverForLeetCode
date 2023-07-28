class Solution {
public:
    int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        
        int sum = 0;
        int num = 0;
        int num_0 = 0;
        int num_1 = 0;
        int num_2 = 0;
        while(num < k){
            if(num_0 < numZeros){
                sum += 0;
                num_0++;
            }
            else if(num_1 < numOnes){
                sum += 1;
                num_1++;
            }
            else if(num_2 < numNegOnes){
                sum -= 1;
                num_2++;
            }
            num++;
        }
        return sum;
    }
};