class Solution {
    public int reverse(int x) {
        
        String s = String.valueOf(x);
        String[] arr = s.split("");
        String res = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].equals("-")) {
                res = "-" + res;
            } else {
                res += arr[i];
            }
        }
        try {
            return Integer.valueOf(res);
        } catch (Exception e) {
            return 0;
        }
    }
}