class Solution {
    public List<String> removeInvalidParentheses(String s) {
        
        List<String> res = new ArrayList<>();
        if (s == null) return res;
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(s);
        visited.add(s);
        boolean found = false;
        while (!q.isEmpty()) {
            String str = q.poll();
            if (isValid(str)) {
                res.add(str);
                found = true;
            }
            if (found) continue;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != '(' && str.charAt(i) != ')') continue;
                String newStr = str.substring(0, i) + str.substring(i + 1);
                if (!visited.contains(newStr)) {
                    q.offer(newStr);
                    visited.add(newStr);
                }
            }
        }
        return res;
    }
    
    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }
}