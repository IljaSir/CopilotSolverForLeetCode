class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;
        for (String log : logs) {
            String[] logParts = log.split(":");
            int funcId = Integer.parseInt(logParts[0]);
            String type = logParts[1];
            int timestamp = Integer.parseInt(logParts[2]);
            if (type.equals("start")) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += timestamp - prevTime;
                }
                stack.push(funcId);
                prevTime = timestamp;
            } else {
                result[stack.pop()] += timestamp - prevTime + 1;
                prevTime = timestamp + 1;
            }
        }
        return result;
    }
}