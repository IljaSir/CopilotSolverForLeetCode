class Solution {
    public String minRemoveToMakeValid(String s) {
        
        int n = s.length();
        List<Integer> indexesToRemove = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    indexesToRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            indexesToRemove.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!indexesToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}