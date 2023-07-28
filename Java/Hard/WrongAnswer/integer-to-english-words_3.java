class Solution {
    public String numberToWords(int num) {
        
        if (num == 0) {
            return "Zero";
        }
        String[] digits = {
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine"
        };
        String[] tens = {
            "Ten",
            "Twenty",
            "Thirty",
            "Forty",
            "Fifty",
            "Sixty",
            "Seventy",
            "Eighty",
            "Ninety"
        };
        String[] teens = {
            "Eleven",
            "Twelve",
            "Thirteen",
            "Fourteen",
            "Fifteen",
            "Sixteen",
            "Seventeen",
            "Eighteen",
            "Nineteen"
        };
        String[] thousands = {
            "Thousand",
            "Million",
            "Billion"
        };
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0) {
            if (num % 1000 > 0) {
                StringBuilder temp = new StringBuilder();
                helper(temp, num % 1000, digits, tens, teens);
                temp.append(thousands[i]).append(" ");
                sb.insert(0, temp);
            }
            num /= 1000;
            i++;
        }
        return sb.toString().trim();
    }
    private void helper(StringBuilder sb, int num, String[] digits, String[] tens, String[] teens) {
        if (num == 0) {
            return;
        } else if (num < 10) {
            sb.append(digits[num - 1]).append(" ");
        } else if (num < 20) {
            sb.append(teens[num - 11]).append(" ");
        } else if (num < 100) {
            sb.append(tens[num / 10 - 1]).append(" ");
            helper(sb, num % 10, digits, tens, teens);
        } else {
            sb.append(digits[num / 100 - 1]).append(" Hundred ");
            helper(sb, num % 100, digits, tens, teens);
        }
    }
}