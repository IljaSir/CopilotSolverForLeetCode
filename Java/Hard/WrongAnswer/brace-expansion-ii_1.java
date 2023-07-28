class Solution {
    public List<String> braceExpansionII(String expression) {
        
        List<String> result = new ArrayList<>();
        Stack<List<String>> stack = new Stack<>();
        stack.push(new ArrayList<>());
        int i = 0;
        while (i < expression.length()) {
            char c = expression.charAt(i);
            if (c == '{') {
                int j = i;
                int count = 0;
                while (j < expression.length()) {
                    if (expression.charAt(j) == '{') {
                        count++;
                    } else if (expression.charAt(j) == '}') {
                        count--;
                    }
                    if (count == 0) {
                        break;
                    }
                    j++;
                }
                List<String> temp = braceExpansionII(expression.substring(i + 1, j));
                List<String> curr = stack.pop();
                stack.push(merge(curr, temp));
                i = j + 1;
            } else if (c == ',') {
                stack.push(new ArrayList<>());
                i++;
            } else {
                List<String> curr = stack.pop();
                curr.add(String.valueOf(c));
                stack.push(curr);
                i++;
            }
        }
        while (!stack.isEmpty()) {
            result.addAll(stack.pop());
        }
        Collections.sort(result);
        return result;
    }
    private List<String> merge(List<String> list1, List<String> list2) {
        List<String> result = new ArrayList<>();
        for (String s1 : list1) {
            for (String s2 : list2) {
                result.add(s1 + s2);
            }
        }
        return result;
    }
}