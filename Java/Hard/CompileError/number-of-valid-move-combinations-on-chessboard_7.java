class Solution {
    public int countCombinations(String[] pieces, int[][] positions) {
        
        int[] move = new int[]{0, 0, 0, 0};
        for (int i = 0; i < pieces.length; i++) {
            int x = positions[i][0];
            int y = positions[i][1];
            if (pieces[i].equals("rook")) {
                move[0] = Math.max(move[0], x - 1);
                move[1] = Math.max(move[1], 8 - x);
                move[2] = Math.max(move[2], y - 1);
                move[3] = Math.max(move[3], 8 - y);
            } else if (pieces[i].equals("queen")) {
                move[0] = Math.max(move[0], x - 1);
                move[1] = Math.max(move[1], 8 - x);
                move[2] = Math.max(move[2], y - 1);
                move[3] = Math.max(move[3], 8 - y);
                move[0] = Math.max(move[0], y - 1);
                move[1] = Math.max(move[1], 8 - y);
                move[2] = Math.max(move[2], x - 1);
                move[3] = Math.max(move[3], 8 - x);
            } else if (pieces[i].equals("bishop")) {
                move[0] = Math.max(move[0], Math.min(x - 1, y - 1));
                move[1] = Math.max(move[1], Math.min(8 - x, 8 - y));
                move[2] = Math.max(move[2], Math.min(x - 1, 8 - y));
                move[3] = Math.max(move[3], Math.min(8 - x, y - 1));
            }
        }
        int result = 0;
        for (int i = 0; i <= move[0]; i++) {
            for (int j = 0; j <= move[1]; j++) {
                for (int k = 0; k <= move[2]; k++) {
                    for (int l = 0; l <= move[3]; l++) {
                        if (i + j + k + l == pieces.length - 1) {
                            result += 2 *
    }
}