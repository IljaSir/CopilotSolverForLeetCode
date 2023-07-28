class Solution {
    public int maximum69Number (int num) {
        
        String s = Integer.toString(num);
        char[] c = s.toCharArray();
        int i = 0;
        while (i < c.length) {
            if (c[i] == '6') {
                c[i] = '9';
                break;
            }
            i++;
        }
        return Integer.parseInt(new String(c));
    }
}