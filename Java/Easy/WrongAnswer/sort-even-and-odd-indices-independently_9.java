class Solution {
    public int[] sortEvenOdd(int[] nums) {
        
        int n = nums.length;
        if(n==1) return nums;
        int mid = n/2;
        int[] even = new int[mid];
        int[] odd = new int[n-mid];
        int e = 0;
        int o = 0;
        for(int i=0; i<n; i++){
            if(i%2==0){
                even[e] = nums[i];
                e++;
            }else{
                odd[o] = nums[i];
                o++;
            }
        }
        Arrays.sort(even);
        Arrays.sort(odd);
        e = 0;
        o = 0;
        for(int i=0; i<n; i++){
            if(i%2==0){
                nums[i] = even[e];
                e++;
            }else{
                nums[i] = odd[o];
                o++;
            }
        }
        return nums;
    }
}