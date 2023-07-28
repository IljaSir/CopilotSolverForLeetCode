class Solution {
    public boolean isPathCrossing(String path) {
        
        int x = 0, y = 0;
        Set<String> set = new HashSet<>();
        set.add(x + "," + y);
        for (char c : path.toCharArray()) {
            if (c == 'N') y++;
            else if (c == 'S') y--;
            else if (c == 'E') x++;
            else x--;
            if (!set.add(x + "," + y)) return true;
        }
        return false;
    }
}