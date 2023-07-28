class Solution {
    public String numberToWords(int num) {
        
        if (num == 0) return "Zero";
        String[] words = {"", "Thousand", "Million", "Billion"};
        String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] teens = {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String res = "";
        int i = 0;
        while (num > 0) {
            int n = num % 1000;
            if (n != 0) {
                res = helper(n, units[i], units, tens, teens, units) + res;
            }
            i++;
            num /= 1000;
        }
        return res.trim();
    }
    
    private String helper(int n, String unit, String[] units, String[] tens, String[] teens, String[] units) {
        int h = n / 100;
        int t = (n % 100) / 10;
        int u = n % 10;
        String res = "";
        if (h != 0) {
            res += units[h] + " Hundred ";
        }
        if (t == 1) {
            res += teens[u] + " ";
        } else {
            if (t != 0) {
                res += tens[t] + " ";
            }
            if (u != 0) {
                res += units[u] + " ";
            }
        }
        res += unit + " ";
        return res;
    }
}