class Solution {
    public String reformatDate(String date) {
        
        String[] d = date.split(" ");
        String day = d[0].substring(0, d[0].length() - 2);
        String month = d[1];
        String year = d[2];
        
        String[] months = new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        int m = 0;
        for (int i = 0; i < months.length; i++) {
            if (month.equals(months[i])) {
                m = i + 1;
                break;
            }
        }
        String mStr = m < 10 ? "0" + String.valueOf(m) : String.valueOf(m);
        String dStr = day.length() == 1 ? "0" + day : day;
        return year + "-" + mStr + "-" + dStr;
    }
}