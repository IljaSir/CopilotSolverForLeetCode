class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        String res = "";
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                while (Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                numStack.push(num);
            } else if (s.charAt(i) == '[') {
                strStack.push(res);
                res = "";
                i++;
            } else if (s.charAt(i) == ']') {
                StringBuilder temp = new StringBuilder(strStack.pop());
                int num = numStack.pop();
                for (int j = ;
    }
}