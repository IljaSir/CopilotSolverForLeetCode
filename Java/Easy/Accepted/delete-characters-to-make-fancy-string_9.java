class Solution {
    public String makeFancyString(String s) {
        
        if (s.length() < 3) {
            return s;
        }
        char[] arr = s.toCharArray();
        int len = arr.length;
        char pre = arr[0];
        int count = 1;
        int idx = 1;
        for (int i = 1; i < len; i++) {
            char c = arr[i];
            if (c == pre) {
                count++;
                if (count < 3) {
                    arr[idx++] = c;
                }
            } else {
                pre = c;
                count = 1;
                arr[idx++] = c;
            }
        }
        return new String(arr, 0, idx);
    }
}