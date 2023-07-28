class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        
        int[] left = new int[26];
        int[] right = new int[26];
        Arrays.fill(left, s.length());
        Arrays.fill(right, -1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            left[c - 'a'] = Math.min(left[c - 'a'], i);
            right[c - 'a'] = Math.max(right[c - 'a'], i);
        }
        int[] stack = new int[s.length()];
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            if (i == left[s.charAt(i) - 'a']) {
                stack[++top] = i;
            }
            if (top >= 0) {
                int l = stack[top];
                int r = right[s.charAt(l) - 'a'];
                if (i == r) {
                    while (top >= 0 && stack[top] >= l) {
                        l = Math.min(l, stack[top--]);
                    }
                    stack[++top] = l;
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i <= top; i++) {
            ans.add(s.substring(stack[i], right[s.charAt(stack[i]) - 'a'] + 1));
        }
        return ans;
    }
}