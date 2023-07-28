class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prev = 0;
        for (String log : logs) {
            String[] strs = log.split(":");
            int id = Integer.parseInt(strs[0]);
            int cur = Integer.parseInt(strs[2]);
            if (strs[1].equals("start")) {
                if (!stack.isEmpty()) {
                    res[stack.peek()] += cur - prev;
                }
                stack.push(id);
                prev = cur;
            } else {
                res[stack.pop()] += cur - prev + 1;
                prev = cur + 1;
            }
        }
        return res;
    }
}