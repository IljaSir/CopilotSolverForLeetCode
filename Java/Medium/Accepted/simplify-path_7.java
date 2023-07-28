class Solution {
    public String simplifyPath(String path) {
        
        Stack<String> stack = new Stack<>();
        String[] pathArray = path.split("/");
        for (String s : pathArray) {
            if (s.equals("") || s.equals(".")) {
                continue;
            }
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
            result.insert(0, "/");
        }
        if (result.length() > 0) {
            return result.toString();
        } else {
            return "/";
        }
    }
}