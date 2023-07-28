class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] restriction : restrictions) {
            int a = restriction[0];
            int b = restriction[1];
            map.get(a).add(b);
            map.get(b).add(a);
        }
        boolean[] result = new boolean[requests.length];
        for (int i = 0; i < requests.length; i++) {
            int a = requests[i][0];
            int b = requests[i][1];
            if (a == b) {
                result[i] = false;
                continue;
            }
            if (map.get(a).contains(b)) {
                result[i] = false;
                continue;
            }
            if (map.get(b).contains(a)) {
                result[i] = false;
                continue;
            }
            Set<Integer> set = new HashSet<>();
            set.add(a);
            set.add(b);
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(a);
            queue.offer(b);
            boolean flag = false;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    int cur = queue.poll();
                    for (int next : map.get(cur)) {
                        if (set.contains(next)) {
                            continue;
                        }
                        if (next == a || next == b) {
                            flag = true;
                            break;
                        }
                        set.add(next);
                        queue.offer(next);
                    }
                    if (flag) {
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            result[i] = !flag;
        }
        return result;
    }
}