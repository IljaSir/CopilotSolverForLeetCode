class Solution {
    public String simplifyPath(String path) {
        
        String[] paths = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String p : paths) {
            if (p.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!p.equals("") && !p.equals(".") && !p.equals("..")) {
                stack.push(p);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append("/");
            result.append(stack.pollLast());
        }
        return result.toString();
    }
}