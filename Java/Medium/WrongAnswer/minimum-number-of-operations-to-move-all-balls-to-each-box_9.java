class Solution {
    public int[] minOperations(String boxes) {
        
        int n = boxes.length();
        int[] ans = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(boxes.charAt(i)=='1'){
                count++;
            }
            left[i] = count;
        }
        count = 0;
        for(int i=n-1;i>=0;i--){
            if(boxes.charAt(i)=='1'){
                count++;
            }
            right[i] = count;
        }
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i] = left[i] + right[i];
        }
        return res;
    }
}