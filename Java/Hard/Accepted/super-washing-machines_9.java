class Solution {
    public int findMinMoves(int[] machines) {
        
        int sum = 0;
        for(int i = 0; i < machines.length; i++){
            sum += machines[i];
        }
        if(sum % machines.length != 0){
            return -1;
        }
        int avg = sum / machines.length;
        int count = 0, max = 0;
        for(int i = 0; i < machines.length; i++){
            count += machines[i] - avg;
            max = Math.max(Math.max(Math.abs(count), max), machines[i] - avg);
        }
        return max;
    }
}