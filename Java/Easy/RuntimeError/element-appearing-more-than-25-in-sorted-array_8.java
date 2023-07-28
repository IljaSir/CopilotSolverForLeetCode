class Solution {
    public int findSpecialInteger(int[] arr) {
        
        int len = arr.length;
        int count = 0;
        for(int i=0; i<len; i++){
            if(arr[i] == arr[i+1]){
                count++;
            }else{
                if(count > len/4){
                    return arr[i];
                }
                count = 0;
            }
        }
        return 0;
    }
}