class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;
        for (String log : logs) {
            String[] arr = log.split(":");
            int id = Integer.parseInt(arr[0]);
            String type = arr[1];
            int time = Integer.parseInt(arr[2]);
            if (type.equals("start")) {
                if (!stack.isEmpty()) {
                    res[stack.peek()] += time - prevTime;
                }
                stack.push(id);
                prevTime = time;
            } else {
                res[stack.pop()] += time - prevTime + 1;
                prevTime = time + 1;
            }
        }
        return res;
    }
}