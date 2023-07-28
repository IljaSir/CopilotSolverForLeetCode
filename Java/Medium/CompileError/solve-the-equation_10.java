class Solution {
    public String solveEquation(String equation) {
        
        String[] parts = equation.split("=");
        int[] left = evaluate(parts[0]);
        int[] right = evaluate(parts[1]);
        if (left[0] == right[0] && left[1] == right[1]) {
            return "Infinite solutions";
        } else if (left[0] == right[0]) {
            return "No solution";
        } else {
            return "x=" + (right[1] - left[1]) / (left[0] - right[0]);
        }
    }
    private int[] evaluate(String exp) {nt(s);
            }
        }
        return res;
    }
}