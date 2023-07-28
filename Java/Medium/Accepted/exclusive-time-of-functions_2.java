class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prev = 0;
        for (String log : logs) {
            String[] arr = log.split(":");
            int curr = Integer.parseInt(arr[2]);
            if (arr[1].equals("start")) {
                if (!stack.isEmpty()) {
                    res[stack.peek()] += curr - prev;
                }
                stack.push(Integer.parseInt(arr[0]));
                prev = curr;
            } else {
                res[stack.pop()] += curr - prev + 1;
                prev = curr + 1;
            }
        }
        return res;
    }
}