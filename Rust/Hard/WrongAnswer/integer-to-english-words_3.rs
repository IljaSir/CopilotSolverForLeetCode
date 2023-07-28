impl Solution {
    pub fn number_to_words(num: i32) -> String {
        
        if num == 0 {
            return "Zero".to_string();
        }
        let mut num = num;
        let mut res = "".to_string();
        let mut idx = 0;
        let units = vec!["", "Thousand", "Million", "Billion"];
        while num > 0 {
            let n = num % 1000;
            if n > 0 {
                res = format!("{} {} {}", Solution::helper(n), units[idx], res);
            }
            idx += 1;
            num /= 1000;
        }
        res.trim().to_string()
    }

    fn helper(num: i32) -> String {
        let mut num = num;
        let mut res = "".to_string();
        let mut idx = 0;
        let tens = vec!["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"];
        let below_20 = vec!["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"];
        while num > 0 {
            let n = num % 10;
            if idx == 0 {
                res = format!("{} {}", below_20[n as usize], res);
            } else if idx == 1 {
                if n == 1 {
                    res = format!("{} {}", below_20[num as usize], res);
                    break;
                } else {
                    res = format!("{} {}", tens[n as usize], res);
                }
            } else {
                res = format!("{} Hundred {}", below_20[n as usize], res);
            }
            idx += 1;
            num /= 10;
        }
        res.trim().to_string()
    }
}