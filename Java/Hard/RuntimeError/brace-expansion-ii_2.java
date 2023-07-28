class Solution {
    public List<String> braceExpansionII(String expression) {
        
        List<String> result = new ArrayList<>();
        Stack<List<String>> stack = new Stack<>();
        stack.push(new ArrayList<>());
        stack.peek().add("");
        for (char c : expression.toCharArray()) {
            if (c == '{') {
                stack.push(new ArrayList<>());
            } else if (c == ',') {
                stack.peek().add("");
            } else if (c == '}') {
                List<String> list = stack.pop();
                Collections.sort(list);
                stack.peek().add(String.join("", list));
            } else {
                stack.peek().set(stack.peek().size() - 1, stack.peek().get(stack.peek().size() - 1) + c);
            }
        }
        List<String> list = stack.pop();
        Collections.sort(list);
        for (String s : list) {
            if (!result.contains(s)) {
                result.add(s);
            }
        }
        return result;
    }
}