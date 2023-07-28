class Solution {
    public int countVowelSubstrings(String word) {
        
        int a = 0, e = 0, i = 0, o = 0, u = 0;
        int count = 0;
        for(char c : word.toCharArray()) {
            switch(c) {
                case 'a':
                    a++;
                    break;
                case 'e':
                    e += a;
                    break;
                case 'i':
                    i += e;
                    break;
                case 'o':
                    o += i;
                    break;
                case 'u':
                    u += o;
                    break;
            }
            count += a + e + i + o + u;
        }
        return count;
    }
}