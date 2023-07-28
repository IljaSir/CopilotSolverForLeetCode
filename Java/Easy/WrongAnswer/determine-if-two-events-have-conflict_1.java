class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        
        int start1 = Integer.parseInt(event1[0].split(":")[0]) * 60 + Integer.parseInt(event1[0].split(":")[1]);
        int end1 = Integer.parseInt(event1[1].split(":")[0]) * 60 + Integer.parseInt(event1[1].split(":")[1]);
        int start2 = Integer.parseInt(event2[0].split(":")[0]) * 60 + Integer.parseInt(event2[0].split(":")[1]);
        int end2 = Integer.parseInt(event2[1].split(":")[0]) * 60 + Integer.parseInt(event2[1].split(":")[1]);
        return (start1 < start2 && start2 < end1) || (start1 < end2 && end2 < end1) || (start2 < start1 && start1 < end2) || (start2 < end1 && end1 < end2);
    }
}