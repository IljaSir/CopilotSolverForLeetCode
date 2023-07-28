class Solution {
    public int finalValueAfterOperations(String[] operations) {
        
        int value = 0;
        for(String op : operations) {
            if(op.equals("++X") || op.equals("X++")) {
                value += 1;
            } else {
                value -= 1;
            }
        }
        return value;
    }
}