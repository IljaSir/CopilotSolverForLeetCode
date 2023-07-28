class Solution {
    public boolean canReach(int[] arr, int start) {
        
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            if (arr[index] == 0) {
                return true;
            }
            if (!visited.contains(index)) {
                visited.add(index);
                if (index - arr[index] >= 0) {
                    queue.offer(index - arr[index]);
                }
                if (index + arr[index] < arr.length) {
                    queue.offer(index + arr[index]);
                }
            }
        }
        return false;
    }
}