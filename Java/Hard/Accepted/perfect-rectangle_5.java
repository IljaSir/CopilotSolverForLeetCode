class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int top = Integer.MIN_VALUE;
        int bottom = Integer.MAX_VALUE;
        int area = 0;
        Set<String> set = new HashSet<>();
        for (int[] rec : rectangles) {
            left = Math.min(left, rec[0]);
            bottom = Math.min(bottom, rec[1]);
            right = Math.max(right, rec[2]);
            top = Math.max(top, rec[3]);
            area += (rec[2] - rec[0]) * (rec[3] - rec[1]);
            String s1 = rec[0] + " " + rec[1];
            String s2 = rec[0] + " " + rec[3];
            String s3 = rec[2] + " " + rec[3];
            String s4 = rec[2] + " " + rec[1];
            if (!set.add(s1)) set.remove(s1);
            if (!set.add(s2)) set.remove(s2);
            if (!set.add(s3)) set.remove(s3);
            if (!set.add(s4)) set.remove(s4);
        }
        if (!set.contains(left + " " + top) || !set.contains(left + " " + bottom) || !set.contains(right + " " + top) || !set.contains(right + " " + bottom) || set.size() != 4) return false;
        return area == (right - left) * (top - bottom);
    }
}