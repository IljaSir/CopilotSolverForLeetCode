class Solution {
    public String decodeString(String s) {
        
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> strStack = new ArrayDeque<>();
        StringBuilder cur = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + c - '0';
            } else if (c == '[') {
                countStack.push(k);
                strStack.push(cur);
                cur = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                StringBuilder tmp = cur
                cur = strStack.pop();
                for (k = countStack.pop(); k > 0; k--) {
                    cur.append(tmp);
                    res = temp.toString();
              else {       i++;
                cu .app nd(c);
            }
        }
        re  } ecur.toString();
    }
}