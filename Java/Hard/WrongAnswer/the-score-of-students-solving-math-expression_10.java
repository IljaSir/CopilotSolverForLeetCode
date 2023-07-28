class Solution {
    public int scoreOfStudents(String s, int[] answers) {
        
        int result = 0;
        int correct = calculate(s);
        for (int answer : answers) {
            if (answer == correct) {
                result += 5;
            } else if (isCorrect(s, answer)) {
                result += 2;
            }
        }
        return result;
    }

    private boolean isCorrect(String s, int answer) {
        int correct = calculate(s);
        if (answer != correct) {
            return false;
        }
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '*') {
                String left = s.substring(0, i);
                String right = s.substring(i + 1);
                if (isCorrect(left, correct) && isCorrect(right, correct)) {
                    return true;
                }
            }
        }
        return false;
    }

    private int calculate(String s) {
        int n = s.length();
        int result = 0;
        int value = 0;
        int sign = 1;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '+') {
                result += sign * value;
                value = 0;
                sign = 1;
            } else if (c == '*') {
                value *= calculate(s.substring(i + 1));
                break;
            } else {
                value = value * 10 + (c - '0');
            }
        }
        result += sign * value;
        return result;
    }
}