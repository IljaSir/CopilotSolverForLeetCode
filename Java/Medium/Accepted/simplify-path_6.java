class Solution {
    public String simplifyPath(String path) {
        
        String[] pathArr = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : pathArr) {
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
        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        return res.length() == 0 ? "/" : res;
    }
}