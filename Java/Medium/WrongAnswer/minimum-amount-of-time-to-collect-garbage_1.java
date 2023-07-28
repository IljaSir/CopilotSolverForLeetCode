class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        
        int[] metal = new int[garbage.length];
        int[] paper = new int[garbage.length];
        int[] glass = new int[garbage.length];
        for (int i = 0; i < garbage.length; i++) {
            metal[i] = paper[i] = glass[i] = -1;
            for (char c : garbage[i].toCharArray()) {
                if (c == 'M') {
                    metal[i] = 0;
                } else if (c == 'P') {
                    paper[i] = 0;
                } else {
                    glass[i] = 0;
                }
            }
        }
        for (int i = 1; i < metal.length; i++) {
            if (metal[i] != -1) {
                metal[i] = metal[i - 1] + travel[i - 1];
            }
            if (paper[i] != -1) {
                paper[i] = paper[i - 1] + travel[i - 1];
            }
            if (glass[i] != -1) {
                glass[i] = glass[i - 1] + travel[i - 1];
            }
        }
        return Math.min(metal[metal.length - 1], Math.min(paper[paper.length - 1], glass[glass.length - 1]));
    }
}