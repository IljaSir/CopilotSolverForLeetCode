class Solution {
public:
    long long smallestNumber(long long num) {
        
        long long res = 0;
        int arr[10] = {0};
        while(num){
            arr[num%10]++;
            num/=10;
        }
        for(int i=1;i<10;i++){
            while(arr[i]--){
                res = res*10 + i;
            }
        }
        while(arr[0]--){
            res = res*10;
        }
        return res;
    }
};