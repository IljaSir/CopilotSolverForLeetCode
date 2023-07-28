class Solution {
    public int maxDistance(int[] position, int m) {
        
        Arrays.sort(position);
        int lo = 0;
        int hi = position[position.length-1] - position[0];
        while(lo < hi){
            int mid = lo + (hi - lo + 1) / 2;
            if(check(position, m, mid)){
                lo = mid;
            }else{
                hi = mid - 1;
            }
        }
        return lo;
    }
    
    private boolean check(int[] position, int m, int mid){
        int count = 1;
        int prev = position[0];
        for(int i = 1; i < position.length; i++){
            if(position[i] - prev >= mid){
                count++;
                prev = position[i];
            }
        }
        return count >= m;
    }
}