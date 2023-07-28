class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        
        int minx = Integer.MAX_VALUE, miny = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE, maxy = Integer.MIN_VALUE;
        Set<String> set = new HashSet<>();
        int area = 0;
        for (int[] rec: rectangles) {
            minx = Math.min(minx, rec[0]);
            miny = Math.min(miny, rec[1]);
            maxx = Math.max(maxx, rec[2]);
            maxy = Math.max(maxy, rec[3]);
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
        if (!set.contains(minx + " " + miny) || !set.contains(minx + " " + maxy) || !set.contains(maxx + " " + maxy) || !set.contains(maxx + " " + miny) || set.size() != 4) return false;
        return area == (maxx - minx) * (maxy - miny);
    }
}