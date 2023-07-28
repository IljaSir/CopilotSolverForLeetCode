class Solution {
    public long smallestNumber(long num) {
        
        if (num == 0) return 0;
        boolean isNegative = num < 0;
        if (isNegative) num = -num;
        String s = String.valueOf(num);
        char[] c = s.toCharArray();
        Arrays.sort(c);
        if (c[0] == '0') {
            int i = 0;
            while (c[i] == '0') i++;
            char temp = c[i];
            c[i] = c[0];
            c[0] = temp;
        }
        num = Long.parseLong(new String(c));
        return isNegative ? -num : num;
    }
}