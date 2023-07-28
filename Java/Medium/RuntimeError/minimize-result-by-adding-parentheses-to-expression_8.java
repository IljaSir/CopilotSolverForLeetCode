class Solution {
    public String minimizeResult(String expression) {
        
        int i = expression.indexOf('+');
        int a = Integer.parseInt(expression.substring(0, i));
        int b = Integer.parseInt(expression.substring(i + 1));
        int c = a + b;

        String ans = String.valueOf(c);
        int len = ans.length();

        for (int j = 1; j < len; ++j) {
            int x = Integer.parseInt(ans.substring(0, j));
            int y = Integer.parseInt(ans.substring(j));
            int z = x + y;

            if (z < c) {
                c = z;
                ans = String.valueOf(x) + "(" + ans.substring(j) + ")";
            }
        }

        return ans;
    }
}