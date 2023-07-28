class Solution {
    public int minimumEffort(int[][] tasks) {
        
        Arrays.sort(tasks, (a, b) -> a[1] - a[0] - b[1] + b[0]);
        int energy = 0;
        for (int[] task : tasks) {
            energy = Math.max(energy + task[0], task[1]);
        }
        return energy;
    }
}