class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        
        int[] boxes = new int[46];
        for (int i = lowLimit; i <= highLimit; i++) {
            int box = 0;
            int num = i;
            while (num > 0) {
                box += num % 10;
                num /= 10;
            }
            boxes[box]++;
        }
        int max = 0;
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i] > max) {
                max = boxes[i];
            }
        }
        return max;
    }
}