class Solution {
    public String removeStars(String s) {
        
        char[] ch = s.toCharArray();
        int len = ch.length;
        int[] index = new int[len];
        int l = 0;
        int r = 0;
        for(int i = 0; i < len; i++) {
            if(ch[i] == '*') {
                index[r++] = i;
            }
        }
        int i = 0;
        int j = 0;
        while(i < len && j < r) {
            if(ch[i] == '*') {
                i++;
            } else {
                if(i < index[j]) {
                    ch[i] = ch[index[j]];
                    ch[index[j]] = '*';
                    j++;
                }
                i++;
            }
        }
        return new String(ch).substring(0, len - r);
    }
}