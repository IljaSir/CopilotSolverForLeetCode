class Solution {
    public int findMinMoves(int[] machines) {
        
        int sum = 0;
        for (int i = 0; i < machines.length; i++) {
            sum += machines[i];
        }
        if (sum % machines.length != 0) {
            return -1;
        }
        int avg = sum / machines.length;
        int[] diff = new int[machines.length];
        for (int i = 0; i < machines.length; i++) {
            diff[i] = machines[i] - avg;
        }
        int max = 0, sum1 = 0;
        for (int i = 0; i < machines.length; i++) {
            sum1 += diff[i];
            max = Math.max(max, Math.max(Math.abs(sum1), diff[i]));
        }
        return max;
    }
}