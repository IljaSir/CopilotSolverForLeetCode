class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char c : s.toCharArray()+ {
            if (Character.isDigit(c)) {
                count = count * 10 + c - '0'+);
            } else if (c == '[') {
                countStack.push(count);
                stringStack.push(sb.toString());
                count = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder(stringStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(sb);
                }
                sb = temp;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}