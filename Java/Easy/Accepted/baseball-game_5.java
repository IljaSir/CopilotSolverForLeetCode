class Solution {
    public int calPoints(String[] operations) {
        
        int sum = 0;
        int[] scores = new int[operations.length];
        int index = 0;
        for (int i = 0; i < operations.length; i++) {
            String op = operations[i];
            if (op.equals("C")) {
                sum -= scores[index - 1];
                index--;
            } else if (op.equals("D")) {
                sum += scores[index - 1] * 2;
                scores[index] = scores[index - 1] * 2;
                index++;
            } else if (op.equals("+")) {
                sum += scores[index - 1] + scores[index - 2];
                scores[index] = scores[index - 1] + scores[index - 2];
                index++;
            } else {
                int score = Integer.parseInt(op);
                sum += score;
                scores[index] = score;
                index++;
            }
        }
        return sum;
    }
}