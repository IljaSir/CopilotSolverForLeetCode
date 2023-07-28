impl Solution {
    pub fn number_to_words(num: i32) -> String {
        
        if num == 0 {
            return "Zero".to_string();
        }
        let mut num = num as u32;
        let mut res = String::new();
        let mut unit = 0;
        let units = ["", " Thousand", " Million", " Billion"];
        while num > 0 {
            let mut tmp = String::new();
            let mut n = num % 1000;
            num /= 1000;
            if n >= 100 {
                tmp.push_str(Self::digit_to_words((n / 100) as u8));
                tmp.push_str(" Hundred");
                n %= 100;
            }
            if n >= 20 {
                tmp.push_str(Self::tens_to_words((n / 10) as u8));
                n %= 10;
            }
            if n > 0 {
                tmp.push_str(Self::digit_to_words(n as u8));
            }
            if !tmp.is_empty() {
                if unit > 0 {
                    tmp.push_str(units[unit]);
                }
                if !res.is_empty() {
                    tmp.push(' ');
                }
                res = tmp + &res;
            }
            unit += 1;
        }
        res
    }
    fn digit_to_words(d: u8) -> &'static str {
        match d {
            1 => "One",
            2 => "Two",
            3 => "Three",
            4 => "Four",
            5 => "Five",
            6 => "Six",
            7 => "Seven",
            8 => "Eight",
            9 => "Nine",
            _ => "",
        }
    }
    fn tens_to_words(t: u8) -> &'static str {
        match t {
            2 => "Twenty",
            3 => "Thirty",
            4 => "Forty",
            5 => "Fifty",
            6 => "Sixty",
            7 => "Seventy",
            8 => "Eighty",
            9 => "Ninety",
            _ => "",
        }
    }
}