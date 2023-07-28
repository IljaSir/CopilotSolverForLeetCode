impl Solution {
    pub fn number_to_words(num: i32) -> String {
        
        if num == 0 {
            return "Zero".to_string();
        }
        let mut res = String::new();
        let mut num = num;
        let mut idx = 0;
        let units = ["", " Thousand", " Million", " Billion"];
        while num > 0 {
            let mut part = Self::part_to_words(num % 1000);
            if !part.is_empty() {
                part.push_str(units[idx]);
                if !res.is_empty() {
                    part.push(' ');
                }
                res = part + &res;
            }
            num /= 1000;
            idx += 1;
        }
        res
    }
    
    fn part_to_words(num: i32) -> String {
        let mut res = String::new();
        let ones = ["", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine"];
        let tens = ["", " Ten", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"];
        let teens = [" Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"];
        let mut num = num;
        let mut idx = 0;
        while num > 0 {
            match idx {
                0 => {
                    res = ones[num % 10].to_string() + &res;
                },
                1 => {
                    if num % 10 == 1 {
                        res = teens[(num % 10) as usize].to_string() + &res;
                    } else {
                        res = tens[num % 10].to_string() + &res;
                    }
                },
                2 => {
                    res = ones[num % 10].to_string() + " Hundred" + &res;
                },
                _ => {},
            }
            num /= 10;
            idx += 1;
        }
        res
    }
}