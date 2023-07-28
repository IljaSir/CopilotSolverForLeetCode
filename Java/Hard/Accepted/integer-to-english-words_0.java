class Solution {
    public String numberToWords(int num) {
        
        if (num == 0) return "Zero";
        String[] thousands = {"", "Thousand", "Million", "Billion"};
        int i = 0;
        String words = "";
        while (num > 0) {
            if (num % 1000 != 0) {
                words = helper(num % 1000) + thousands[i] + " " + words;
            }
            num /= 1000;
            i++;
        }
        return words.trim();
    }
    
    private String helper(int num) {
        String[] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return below20[num] + " ";
        } else if (num < 100) {
            return tens[num / 10] + " " + helper(num % 10);
        } else {
            return below20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}