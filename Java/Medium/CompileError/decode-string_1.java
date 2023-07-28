class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> count = new Stack<>();
        Stack<String> result = new Stack<>();
        String res =  result = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = 10 * count + (s.charAt(index) - '0');
                    index++;
                }
                countStack.push(count);
            } else if (s.charAt(index) == '[') {
                resultStack.push(result);
                result = new StringBuilder();
                index++;
            } else if (s.charAt(index) == ']') {
                StringBuilder temp = resultStack.pop();
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(result);
                }
                result = temp;
                index++;
            } else {
                result.append(s.charAt(index++));
            }
        }
        return result.toString();
    }
}