class Solution {
    public String numberToWords(int num) {
        
        if (num == 0) {
            return "Zero";
        }
        String[] levels = {"", "Thousand", "Million", "Billion"};
        int level = 0;
        String result = "";
        while (num > 0) {
            if (num % 1000 != 0) {
                result = helper(num % 1000) + levels[level] + " " + result;
            }
            num /= 1000;
            level++;
        }
        return result.trim();
    }
    
    private String helper(int num) {
        String[] belowTen = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] belowTwenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] belowHundred = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        if (num == 0) {
            return "";
        } else if (num < 10) {
            return belowTen[num] + " ";
        } else if (num < 20) {
            return belowTwenty[num - 10] + " ";
        } else if (num < 100) {
            return belowHundred[num / 10] + " " + helper(num % 10);
        } else {
            return belowTen[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}