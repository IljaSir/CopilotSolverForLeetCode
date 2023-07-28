class Solution {
    public int calPoints(String[] operations) {
        
        int[] scores = new int[operations.length];
        int index = 0;
        int sum = 0;
        for (String operation : operations) {
            if (operation.equals("+")) {
                scores[index] = scores[index - 1] + scores[index - 2];
                sum += scores[index];
                index++;
            } else if (operation.equals("D")) {
                scores[index] = scores[index - 1] * 2;
                sum += scores[index];
                index++;
            } else if (operation.equals("C")) {
                sum -= scores[index - 1];
                index--;
            } else {
                scores[index] = Integer.parseInt(operation);
                sum += scores[index];
                index++;
            }
        }
        return sum;
    }
}