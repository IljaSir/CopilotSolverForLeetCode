class Solution {
    public String thousandSeparator(int n) {
        
        if(n == 0) return "0";
        String s = "";
        int cnt = 0;
        while(n > 0) {
            if(cnt == 3) {
                s = "." + s;
                cnt = 0;
            }
            s = String.valueOf(n % 10) + s;
            n /= 10;
            cnt++;
        }
        return s;
    }
}