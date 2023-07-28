class Solution {
    public String interpret(String command) {
        
        String result = "";
        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            if (c == 'G') {
                result += 'G';
            } else if (c == '(' && command.charAt(i + 1) == ')') {
                result += 'o';
                i++;
            } else if (c == '(' && command.charAt(i + 1) == 'a') {
                result += "al";
                i += 3;
            }
        }
        return result;
    }
}