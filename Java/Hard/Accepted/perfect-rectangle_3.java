class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        
        int x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE, y2 = Integer.MIN_VALUE;
        Set<String> set = new HashSet();
        int area = 0;
        for (int[] rectangle : rectangles) {
            x1 = Math.min(x1, rectangle[0]);
            y1 = Math.min(y1, rectangle[1]);
            x2 = Math.max(x2, rectangle[2]);
            y2 = Math.max(y2, rectangle[3]);
            area += (rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1]);
            String s1 = rectangle[0] + " " + rectangle[1];
            String s2 = rectangle[0] + " " + rectangle[3];
            String s3 = rectangle[2] + " " + rectangle[3];
            String s4 = rectangle[2] + " " + rectangle[1];
            if (!set.add(s1)) set.remove(s1);
            if (!set.add(s2)) set.remove(s2);
            if (!set.add(s3)) set.remove(s3);
            if (!set.add(s4)) set.remove(s4);
        }
        if (!set.contains(x1 + " " + y1) || !set.contains(x1 + " " + y2) || !set.contains(x2 + " " + y1) || !set.contains(x2 + " " + y2) || set.size() != 4) return false;
        return area == (x2 - x1) * (y2 - y1);
    }
}