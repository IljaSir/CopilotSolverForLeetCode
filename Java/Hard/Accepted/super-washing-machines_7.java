class Solution {
    public int findMinMoves(int[] machines) {
        
        int sum = 0;
        for (int i : machines) {
            sum += i;
        }
        if (sum % machines.length != 0) {
            return -1;
        }
        int avg = sum / machines.length;
        int cnt = 0;
        int max = 0;
        for (int load : machines) {
            cnt += load - avg;
            max = Math.max(Math.max(Math.abs(cnt), load - avg), max);
        }
        return max;
    }
}