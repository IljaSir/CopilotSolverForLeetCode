class Solution {
    public double average(int[] salary) {
        
        double sum = 0;
        double min = salary[0];
        double max = salary[0];
        for (int sal : salary) {
            sum += sal;
            if (sal < min) {
                min = sal;
            }
            if (sal > max) {
                max = sal;
            }
        }
        return (sum - min - max) / (salary.length - 2);
    }
}