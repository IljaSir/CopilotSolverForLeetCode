class Solution {
    public String numberToWords(int num) {
        
        if (num == 0) {
            return "Zero";
        }
        String[] units = new String[]{"", "Thousand", "Million", "Billion"};
        String[] digits = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String res = "";
        int i = 0;
        while (num > 0) {
            int d = num % 1000;
            String dStr = "";
            if (d > 0) {
                int h = d / 100;
                if (h > 0) {
                    dStr = digits[h] + " Hundred";
                }
                int t = d % 100;
                if (t > 0) {
                    if (t < 20) {
                        dStr += " " + digits[t];
                    } else {
                        dStr += " " + tens[t / 10];
                        if (t % 10 > 0) {
                            dStr += " " + digits[t % 10];
                        }
                    }
                }
                res = dStr + " " + units[i] + " " + res;
            }
            num /= 1000;
            i++;
        }
        return res.trim();
    }
}