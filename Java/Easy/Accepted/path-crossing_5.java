class Solution {
    public boolean isPathCrossing(String path) {
        
        int x = 0, y = 0;
        Set<String> set = new HashSet<>();
        set.add(x + "," + y);
        for (char c : path.toCharArray()) {
            if (c == 'N') y++;
            if (c == 'S') y--;
            if (c == 'E') x++;
            if (c == 'W') x--;
            if (!set.add(x + "," + y)) return true;
        }
        return false;
    }
}