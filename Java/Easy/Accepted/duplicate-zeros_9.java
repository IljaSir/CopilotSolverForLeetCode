class Solution {
    public void duplicateZeros(int[] arr) {
        
        int n = arr.length;
        int last = n - 1;
        for(int i = 0; i <= last; i++){
            if(arr[i] == 0){
                if(i == last){
                    arr[last] = 0;
                    last--;
                    break;
                }
                for(int j = last; j > i; j--){
                    arr[j] = arr[j-1];
                }
                arr[i+1] = 0;
                i++;
            }
        }
    }
}