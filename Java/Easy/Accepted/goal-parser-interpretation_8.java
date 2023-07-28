class Solution {
    public String interpret(String command) {
        
        String result = "";
        char[] c = command.toCharArray();
        int i = 0;
        while (i < c.length) {
            if (c[i] == 'G') {
                result += c[i];
                i++;
            } else if (c[i] == '(') {
                if (c[i+1] == ')') {
                    result += 'o';
                    i += 2;
                } else {
                    result += "al";
                    i += 4;
                }
            }
        }
        return result;
    }
}