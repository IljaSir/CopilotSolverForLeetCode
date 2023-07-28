class Solution {
    public int convertTime(String current, String correct) {
        
        int min = Integer.parseInt(current.substring(0,2))*60+Integer.parseInt(current.substring(3));
        int max = Integer.parseInt(correct.substring(0,2))*60+Integer.parseInt(correct.substring(3));
        int ans = 0;
        while(min<max) {
            if(max-min>=60) {
                min+=60;
                ans++;
            } else if(max-min>=15) {
                min+=15;
                ans++;
            } else if(max-min>=5) {
                min+=5;
                ans++;
            } else {
                min++;
                ans++;
            }
        }
        return ans;
    }
}