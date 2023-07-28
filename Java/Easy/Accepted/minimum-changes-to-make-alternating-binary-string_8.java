class Solution {
    public int minOperations(String s) {
        
        int n = s.length();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = s.charAt(i)-'0';
        }
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        arr1[0] = 0;
        arr2[0] = 1;
        for(int i=1;i<n;i++){
            arr1[i] = arr1[i-1]==arr[i-1]?1-arr[i-1]:arr[i-1];
            arr2[i] = arr2[i-1]==arr[i-1]?1-arr[i-1]:arr[i-1];
        }
        int c1=0;
        int c2=0;
        for(int i=0;i<n;i++){
            if(arr[i]!=arr1[i]){
                c1++;
            }
            if(arr[i]!=arr2[i]){
                c2++;
            }
        }
        return Math.min(c1,c2);
    }
}