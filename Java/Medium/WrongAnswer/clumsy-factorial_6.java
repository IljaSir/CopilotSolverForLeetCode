class Solution {
    public int clumsy(int n) {
        
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = n - i;
        }
        int result = arr[0];
        int i = 1;
        while(i < n){
            result = result * arr[i];
            i++;
            if(i < n){
                result = result / arr[i];
                i++;
            }
            if(i < n){
                result = result + arr[i];
                i++;
            }
            if(i < n){
                result = result - arr[i];
                i++;
            }
        }
        return result;
    }
}