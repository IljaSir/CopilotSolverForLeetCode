class Solution {
    public int mostBooked(int n, int[][] meetings) {
        
        int[] rooms = new int[n];
        int max = 0;
        for(int[] meeting : meetings){
            for(int i = meeting[0]; i < meeting[1]; i++){
                rooms[i]++;
                max = Math.max(max, rooms[i]);
            }
        }
        for(int i = 0; i < n; i++){
            if(rooms[i] == max){
                return i;
            }
        }
        return -1;
    }
}