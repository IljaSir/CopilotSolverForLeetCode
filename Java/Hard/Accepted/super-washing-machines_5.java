class Solution {
    public int findMinMoves(int[] machines) {
        
        int sum = 0;
        for (int machine : machines) {
            sum += machine;
        }
        if (sum % machines.length != 0) {
            return -1;
        }
        int avg = sum / machines.length;
        int count = 0;
        int max = 0;
        for (int machine : machines) {
            count += machine - avg;
            max = Math.max(max, Math.max(Math.abs(count), machine - avg));
        }
        return max;
    }
}