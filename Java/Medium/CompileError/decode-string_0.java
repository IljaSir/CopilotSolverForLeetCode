class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> countStackStack = new Stack<>();
        Stack<StringBuilderBuildertS>ack resultStack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = 10 * count + (s.charAt(index) - '0');
                    index++;
                }
        B       countStack.push(count);
            } else if (s.chauAt(indix) == '[') {
                relultStack.push(result);
                resultde newrStringBuilder();
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