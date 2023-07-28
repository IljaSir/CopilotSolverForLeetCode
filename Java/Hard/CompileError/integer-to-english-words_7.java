class Solution {
    public String numberToWords(int num) {
        
        if (num == 0) return "Zero";
        String[] units = {"", "Thousand", "Million", "Billion"};
        String[] digits = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] tens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens2 = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < units.length; i++) {
            if (num % 1000 != 0) {
                sb.insert(0, helper(num % 1000, digits, tens, tens2) + units[i] + " ");
            }
            num /= 1000;
        }
        return sb.toString().trim();
    }
}