class Solution {
    public int openLock(String[] deadends, String target) {
        
        if (target.equals("0000")) return 0;
        Set<String> dead = new HashSet<>();
        for (String s : deadends) {
            dead.add(s);
        }
        if (dead.contains("0000")) return -1;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                for (String next : getNext(s)) {
                    if (dead.contains(next)) continue;
                    if (next.equals(target)) return step + 1;
                    if (visited.contains(next)) continue;
                    queue.offer(next);
                    visited.add(next);
                }
            }
            step++;
        }
        return -1;
    }
    private String[] getNext(String s) {
        String[] res = new String[8];
        char[] arr = s.toCharArray();
        for (int i = 0; i < 4; i++) {
            char c = arr[i];
            arr[i] = c == '9' ? '0' : (char)(c + 1);
            res[i * 2] = new String(arr);
            arr[i] = c == '0' ? '9' : (char)(c - 1);
            res[i * 2 + 1] = new String(arr);
            arr[i] = c;
        }
        return res;
    }
}