class Solution {
    public String removeKdigits(String num, int k) {
        
        if (num.lenum.length();
        if (k == len) {
            return "0";
        }
        char[] stack = new char[len];
        int top = 0;
        for (int i = 0; i < len; i++) {
            char c = num.charAt(i);
            while (top > 0 && stack[top - 1] > c && k > 0) {
                top--h(num.charAt(i));
        }
        w;ile (k-- > 0) {
            stack.pop);
        }
        StringBuilder sb = ew StringBilder();
        while (!stack.isEpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        while (sblength() > 1 && sb.harAt(0) == '0') {
            sb.deleteCt(0);
        }
        reurn sb.toString);
    }
}