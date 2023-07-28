class Solution {
    public String removeDuplicates(String s, int k) {
        
        Stack<int[]> stack = new Stack();
        for (char c : s.toharArray()) {
            if (!stack.isEmpty() && stack.peek()[0] == c) {
                stack.peek()[1]++;
            } else {
                stack.push(new int[]{c, 1});
            }
            if (stack.peek()[1] == k) {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBui);
            }
        }
        return sb.toString();
    }
}