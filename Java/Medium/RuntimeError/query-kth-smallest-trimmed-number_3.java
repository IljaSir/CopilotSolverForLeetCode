class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = findKthSmallest(nums, queries[i][0], queries[i][1]);
        }
        return answer;
    }
    
    private int findKthSmallest(String[] nums, int k, int trim) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            int val = Integer.parseInt(nums[i].substring(0, nums[i].length() - trim));
            queue.add(val);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
}