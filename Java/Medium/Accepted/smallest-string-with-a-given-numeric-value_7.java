class Solution {
    public String getSmallestString(int n, int k) {
        
        char[] ch = new char[n];
        int sum = 0;
        for (int i = 0; i < ch.length; i++) {
            ch[i] = 'a';
            sum += 1;
        }
        int i = ch.length - 1;
        while (sum < k) {
            int diff = k - sum;
            if (diff > 25) {
                ch[i] = 'z';
                sum += 25;
            } else {
                ch[i] = (char) (ch[i] + diff);
                sum += diff;
            }
            i--;
        }
        return new String(ch);
    }
}