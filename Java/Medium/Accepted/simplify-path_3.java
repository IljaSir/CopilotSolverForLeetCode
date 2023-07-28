class Solution {
    public String simplifyPath(String path) {
        
        String[] str = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : str) {
            if (s.equals(".") || s.equals("")) {
                continue;
            } else if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}