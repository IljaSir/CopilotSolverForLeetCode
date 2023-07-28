class Solution {
    public String interpret(String command) {
        
        char[] c = command.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'G') {
                sb.append('G');
            } else if (c[i] == '(' && c[i + 1] == ')') {
                sb.append('o');
                i++;
            } else if (c[i] == '(' && c[i + 1] == 'a') {
                sb.append("al");
                i += 3;
            }
        }
        return sb.toString();
    }
}