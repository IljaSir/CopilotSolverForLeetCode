class Solution {
    public String numberToWords(int num) {
        
        if (num == 0) return "Zero";
        String[] thousands = new String[] {"", "Thousand", "Million", "Billion"};
        String[] singles = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] tens = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] teens = new String[] {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        int i = 0;
        String result = "";
        while (num > 0) {
            String temp = "";
            int n = num % 1000;
            if (n > 99) {
                temp += singles[n / 100] + " Hundred";
            }
            if (n % 100 > 10 && n % 100 < 20) {
                temp += " " + teens[n % 100 - 10];
            } else {
                if (n % 100 > 9) {
                    temp += " " + tens[n % 100 / 10];
                }
                if (n % 10 > 0) {
                    temp += " " + singles[n % 10];
                }
            }
            if (temp.trim().length() > 0) {
                result = temp.trim() + " " + thousands[i] + " " + result;
            }
            num = num / 1000;
            i++;
        }
        return result.trim();
    }
}