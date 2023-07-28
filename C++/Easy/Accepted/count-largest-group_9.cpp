class Solution {
public:
    int countLargestGroup(int n) {
        
        int sum = 0;
        int max = 0;
        int count = 0;
        int arr[10000] = {0};
        for(int i = 1; i <= n; i++){
            sum = 0;
            int x = i;
            while(x > 0){
                sum += x % 10;
                x /= 10;
            }
            arr[sum]++;
        }
        for(int i = 0; i < 10000; i++){
            if(arr[i] > max){
                max = arr[i];
                count = 1;
            }
            else if(arr[i] == max){
                count++;
            }
        }
        return count;
    }
};