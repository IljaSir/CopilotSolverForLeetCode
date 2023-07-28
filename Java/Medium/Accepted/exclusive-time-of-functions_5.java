class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;
        for (String log : logs) {
            String[] s = log.split(":");
            int id = Integer.parseInt(s[0]);
            int time = Integer.parseInt(s[2]);
            if (s[1].equals("start")) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += time - prevTime;
                }
                stack.push(id);
                prevTime = time;
            } else {
                result[stack.pop()] += time - prevTime + 1;
                prevTime = time + 1;
            }
        }
        return result;
    }
}