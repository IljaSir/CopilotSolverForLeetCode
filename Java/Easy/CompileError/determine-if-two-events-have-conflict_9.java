class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        
        int[] start1 = convert(event1[0]);
        int[] end1 = convert(event1[1]);
        int[] start2 = convert(event2[0]);
        int[] end2 = convert(event2[1]);
        if (start1[0] > start2[0]) {
            return haveConflict(event2, event1);
        }
        if (start1[0] == start2[0] && start1[1] > start2[1]) {
            return haveConflict(event2, event1);
        }
        if (end1[0] < start2[0]) {
            return false;
        }
        if (end1[0] == start2[0] && end1[1] < start2[1]) {
            return false;
        }
        return true;
    }
}