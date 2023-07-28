class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        
        int s1 = Integer.parseInt(event1[0].replace(":", ""));
        int e1 = Integer.parseInt(event1[1].replace(":", ""));
        int s2 = Integer.parseInt(event2[0].replace(":", ""));
        int e2 = Integer.parseInt(event2[1].replace(":", ""));
        return !(e1 <= s2 || e2 <= s1);
    }
}