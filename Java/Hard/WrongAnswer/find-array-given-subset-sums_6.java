class Solution {
    public int[] recoverArray(int n, int[] sums) {
        
        int[] arr = new int[n];
        int[] nums = new int[1<<n];
        Arrays.sort(sums);
        for(int i = 0; i < sums.length; i++){
            nums[i] = sums[i];
        }
        int[] temp = new int[1<<n];
        for(int i = 0; i < n; i++){
            int j = 0;
            for(int k = 0; k < (1<<n); k++){
                if((k&(1<<i)) == 0){
                    temp[j] = nums[k];
                    j++;
                }
            }
            int[] t = new int[1<<n];
            for(int k = 0; k < (1<<n); k++){
                t[k] = temp[k];
            }
            temp = t;
            int x = 0;
            for(int k = 0; k < (1<<n); k++){
                if(temp[k] == nums[k]){
                    x++;
                }
            }
            if(x == (1<<n)){
                arr[i] = 0;
            }
            else{
                arr[i] = temp[0] - nums[0];
            }
        }
        return arr;
    }
}