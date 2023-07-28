class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        
        int count = 0;
        boolean[] extracted = new boolean[artifacts.length];
        for (int[] d : dig) {
            for (int i = 0; i < artifacts.length; i++) {
                if (!extracted[i]) {
                    if (d[0] >= artifacts[i][0] && d[0] <= artifacts[i][2]
                            && d[1] >= artifacts[i][1] && d[1] <= artifacts[i][3]) {
                        extracted[i] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}