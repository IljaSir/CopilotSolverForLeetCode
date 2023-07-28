class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int[] keys = new int[rooms.size()];
        keys[0] = 1;
        int keyCount = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.empty()) {
            int current = stack.pop();
            for (int key : rooms.get(current)) {
                if (keys[key] == 0) {
                    keys[key] = 1;
                    keyCount++;
                    stack.push(key);
                }
            }
        }
        return keyCount == rooms.size();
    }
}