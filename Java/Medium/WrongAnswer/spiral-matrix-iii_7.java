class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        
        int[][] result = new int[rows * cols][2];
        int index = 0;
        int r = rStart, c = cStart;
        int rStep = 0, cStep = 1;
        int rStepMax = 1, cStepMax = 1;
        int step = 0;
        while (index < result.length) {
            result[index][0] = r;
            result[index][1] = c;
            index++;
            if (r + rStep >= 0 && r + rStep < rows && c + cStep >= 0 && c + cStep < cols) {
                r += rStep;
                c += cStep;
            } else {
                step++;
                if (step == rStepMax) {
                    step = 0;
                    int tmp = rStep;
                    rStep = cStep;
                    cStep = -tmp;
                }
                if (step == cStepMax) {
                    cStepMax++;
                }
            }
        }
        return result;
    }
}