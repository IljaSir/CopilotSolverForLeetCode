class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>();
        for (String log : logs) {
            String[] arr = log.split(":");
            int id = Integer.parseInt(arr[0]);
            int time = Integer.parseInt(arr[2]);
            if (arr[1].equals("start")) {
                stack.push(new int[]{id, time});
            } else {
                int[] cur = stack.pop();
                int interval = time - cur[1] + 1;
                res[id] += interval;
                if (!stack.isEmpty()) {
                    res[stack.peek()[0]] -= interval;
                }
            }
        }
        return res;
    }
}