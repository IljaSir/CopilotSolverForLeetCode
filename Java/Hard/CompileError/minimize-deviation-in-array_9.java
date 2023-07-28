class Solution {
    public int minimumDeviation(int[] nums) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int max = 0;
        for (int num : nums) {
            if (num % 2 == 1) {
                num *= 2;
            }
            queues;
    }
}