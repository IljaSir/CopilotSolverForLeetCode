class Solution {
    public int fillCups(int[] amount) {
        
        int ans = 0;
        for(int i=0; i<3; i++){
            ans += amount[i];
        }
        int[] arr = Arrays.copyOf(amount, 3);
        if(arr[0] > arr[2]){
            int temp = arr[0];
            arr[0] = arr[2];
            arr[2] = temp;
        }
        if(arr[1] > arr[2]){
            int temp = arr[1];
            arr[1] = arr[2];
            arr[2] = temp;
        }
        int min = Math.min(arr[0], arr[1]);
        ans += min;
        arr[0] -= min;
        arr[1] -= min;
        ans += arr[2];
        return ans;
    }
}