class Solution {
    public String maxValue(String n, int x) {
        
        int i = 0;
        int len = n.length();
        char[] arr = n.toCharArray();
        if (arr[0] == '-') {
            i++;
            while (i < len && arr[i] - '0' <= x) {
                i++;
            }
        } else {
            while (i < len && arr[i] - '0' >= x) {
                i++;
            }
        }
        return n.substring(0, i) + x + n.substring(i);
    }
}