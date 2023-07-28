class Solution {
    public boolean canBeValid(String s, String locked) {
        
        int n = s.length();
        int[] count = new int[2];
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '1') {
                count[s.charAt(i) - '(']++;
            }
        }
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0') {
                if (s.charAt(i) == '(') {
                    stack[++top] = i;
                } else if (top >= 0) {
                    top--;
                } else {
                    count[0]++;
                }
            }
        }
        return count[0] == count[1] && top == -1;
    }
}
    }
}