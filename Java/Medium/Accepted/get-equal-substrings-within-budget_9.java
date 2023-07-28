class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        
        int[] arr = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            arr[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int max = 0;
        int sum = 0;
        int l = 0;
        int r = 0;
        while(r < arr.length){
            sum += arr[r];
            if(sum <= maxCost){
                max = Math.max(max, r - l + 1);
            }
            while(sum > maxCost){
                sum -= arr[l];
                l++;
            }
            r++;
        }
        return max;
    }
}