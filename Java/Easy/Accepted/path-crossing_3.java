class Solution {
    public boolean isPathCrossing(String path) {
        
        Set<String> set = new HashSet<>();
        int x = 0, y = 0;
        set.add(x + "," + y);
        for (char c : path.toCharArray()) {
            if (c == 'N') y++;
            if (c == 'S') y--;
            if (c == 'E') x++;
            if (c == 'W') x--;
            String s = x + "," + y;
            if (set.contains(s)) return true;
            set.add(s);
        }
        return false;
    }
}