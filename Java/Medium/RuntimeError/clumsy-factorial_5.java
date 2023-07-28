class Solution {
    public int clumsy(int n) {
        
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = n-i;
        }
        int res = 0;
        for(int i=0; i<n; i++){
            if(i%4 == 0){
                res += arr[i];
            }else if(i%4 == 1){
                res *= arr[i];
            }else if(i%4 == 2){
                res /= arr[i];
            }else if(i%4 == 3){
                res += arr[i];
                res -= arr[i+1];
                i++;
            }
        }
        return res;
    }
}