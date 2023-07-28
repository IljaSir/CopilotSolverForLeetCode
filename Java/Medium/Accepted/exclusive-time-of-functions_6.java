class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int preTime = 0;
        for (String log : logs) {
            String[] strs = log.split(":");
            int curId = Integer.parseInt(strs[0]);
            int curTime = Integer.parseInt(strs[2]);
            if (strs[1].equals("start")) {
                if (!stack.isEmpty()) {
                    res[stack.peek()] += curTime - preTime;
                }
                stack.push(curId);
                preTime = curTime;
            } else {
                res[stack.pop()] += curTime - preTime + 1;
                preTime = curTime + 1;
            }
        }
        return res;
    }
}