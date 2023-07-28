class Solution {
    public String simplifyPath(String path) {
        
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String part : parts) {
            if (part.equals(".") || part.equals("")) {
                continue;
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder simplified = new StringBuilder();
        while (!stack.isEmpty()) {
            simplified.insert(0, "/" + stack.pop());
        }
        return simplified.toString();
    }
}