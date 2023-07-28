class Solution {
    public int minJumps(int[] arr) {
        
        int n = arr.length;
        if (n == 1) {
            return 0;
        }
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited.add(0);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == n - 1) {
                    return step;
                }
                if (cur + 1 < n && !visited.contains(cur + 1)) {
                    queue.add(cur + 1);
                    visited.add(cur + 1);
                }
                if (cur - 1 >= 0 && !visited.contains(cur - 1)) {
                    queue.add(cur - 1);
                    visited.add(cur - 1);
                }
                if (indexMap.containsKey(arr[cur])) {
                    for (int next : indexMap.get(arr[cur])) {
                        if (!visited.contains(next)) {
                            queue.add(next);
                            visited.add(next);
                        }
                    }
                    indexMap.remove(arr[cur]);
                }
            }
            step++;
        }
        return -1;
    }
}