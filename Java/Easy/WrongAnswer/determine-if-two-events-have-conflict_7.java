class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        
        int s1 = Integer.parseInt(event1[0].split(":")[0])*60 + Integer.parseInt(event1[0].split(":")[1]);
        int e1 = Integer.parseInt(event1[1].split(":")[0])*60 + Integer.parseInt(event1[1].split(":")[1]);
        int s2 = Integer.parseInt(event2[0].split(":")[0])*60 + Integer.parseInt(event2[0].split(":")[1]);
        int e2 = Integer.parseInt(event2[1].split(":")[0])*60 + Integer.parseInt(event2[1].split(":")[1]);
        return s1 < e2 && s2 < e1;
    }
}