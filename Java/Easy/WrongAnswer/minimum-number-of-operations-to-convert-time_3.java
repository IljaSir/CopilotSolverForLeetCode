class Solution {
    public int convertTime(String current, String correct) {
        
        int hours = (correct.charAt(0) - '0') * 10 + correct.charAt(1) - '0' - ((current.charAt(0) - '0') * 10 + current.charAt(1) - '0');
        int minutes = (correct.charAt(3) - '0') * 10 + correct.charAt(4) - '0' - ((current.charAt(3) - '0') * 10 + current.charAt(4) - '0');
        if (minutes < 0) {
            minutes += 60;
            hours--;
        }
        return hours * 60 + minutes;
    }
    public int numberOfOperations(String current, String correct) {
        int minutes = convertTime(current, correct);
        int[] operations = new int[]{60, 15, 5, 1};
        int result = 0;
        for (int operation : operations) {
            result += minutes / operation;
            minutes %= operation;
        }
        return result;
    }
}