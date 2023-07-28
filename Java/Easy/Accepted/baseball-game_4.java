class Solution {
    public int calPoints(String[] operations) {
        
        int[] points = new int[operations.length];
        int index = 0;
        for (String op : operations) {
            switch (op) {
                case "C":
                    index--;
                    break;
                case "D":
                    points[index] = points[index-1] * 2;
                    index++;
                    break;
                case "+":
                    points[index] = points[index-1] + points[index-2];
                    index++;
                    break;
                default:
                    points[index] = Integer.parseInt(op);
                    index++;
                    break;
            }
        }

        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += points[i];
        }
        return sum;
    }
}