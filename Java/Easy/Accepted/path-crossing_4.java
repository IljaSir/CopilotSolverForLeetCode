class Solution {
    public boolean isPathCrossing(String path) {
        
        Set<String> visited = new HashSet<>();
        int x = 0;
        int y = 0;
        visited.add("0,0");
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == 'N') {
                y++;
            } else if (c == 'S') {
                y--;
            } else if (c == 'E') {
                x++;
            } else if (c == 'W') {
                x--;
            }
            if (visited.contains(x + "," + y)) {
                return true;
            }
            visited.add(x + "," + y);
        }
        return false;
    }
}