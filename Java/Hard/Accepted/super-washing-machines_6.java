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
        int res = 0;
        int total = 0;
        for (int machine : machines) {
            total += machine - avg;
            res = Math.max(Math.abs(total), Math.max(res, machine - avg));
        }
        return res;
    }
}