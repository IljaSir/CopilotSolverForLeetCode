class Solution {
    public String freqAlphabets(String s) {
        
        char[] arr = s.toCharArray();
        int n = arr.length;
        StringBuilder sb = new StringBuilder();
        for(int i = n - 1; i >= 0; i--) {
            if(arr[i] == '#') {
                int num = (arr[i - 2] - '0') * 10 + (arr[i - 1] - '0');
                sb.append((char)('a' + num - 1));
                i -= 2;
            } else {
                sb.append((char)('a' + arr[i] - '1'));
            }
        }
        return sb.reverse().toString();
    }
}