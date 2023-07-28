class Solution {
    public boolean isPathCrossing(String path) {
        
        int x = 0;
        int y = 0;
        Set<String> set = new HashSet<>();
        set.add("0,0");
        for (char c : path.toCharArray()) {
            if (c == 'N') {
                y++;
            } else if (c == 'S') {
                y--;
            } else if (c == 'E') {
                x++;
            } else if (c == 'W') {
                x--;
            }
            String s = x + "," + y;
            if (set.contains(s)) {
                return true;
            }
            set.add(s);
        }
        return false;
    }
}