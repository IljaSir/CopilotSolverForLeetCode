class Solution {
    public int minOperations(int n) {
        
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = (2*i)+1;
        }
        int mid = arr[n/2];
        int count = 0;
        for(int i=0;i<n/2;i++){
            count+=mid-arr[i];
        }
        return count;
    }
}