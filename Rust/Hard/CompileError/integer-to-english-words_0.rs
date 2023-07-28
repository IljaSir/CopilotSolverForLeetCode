impl Solution {
    pub fn number_to_words(num: i32) -> String {
        
        if num == 0 {
            return "Zero".to_string();
        }
        let mut res = String::new();
        let mut num = num;
        let mut i = 0;
        while num > 0 {
            if num % 1000 != 0 {
                let mut tmp = Self::helper(num % 1000);
                if i > 0 {
                    tmp.push_str(" ");
                    tmp.push_str(Self::unit(i));
                }
                if !res.is_empty() {
                    tmp.push_str(" ");
                }
                res = tmp + &res;
            }
            num /= 1000;
            i += 1;
        }
        res
    }

    fn helper(num: i32) -> String {
        let mut res = String::new();
        let mut num = num;
        let mut i = 0;
        while num > 0 {
            if num % 10 != 0 {
                let mut tmp = Self::digit(num % 10);
                if i > 0 {
                    tmp.push_str(" ");
                    tmp.push_str(Self::tens(i));
                }
                if !res.is_empty() {
                    tmp.push_str(" ");
                }
                res = tmp + &res;
            }
            num /= 10;
            i += 1;
        }
        res
    }

    fn digit(num: i32) -> &'static str {
        match num {
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

    fn tens(num: i32) -> &'static str {
        match num {
            1 => "Ten",
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