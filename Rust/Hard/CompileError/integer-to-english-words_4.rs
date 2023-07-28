impl Solution {
    pub fn number_to_words(num: i32) -> String {
        
        if num == 0 {
            return "Zero".to_string();
        }
        let mut num = num;
        let mut result = String::new();
        let mut tmp = String::new();
        let mut i = 0;
        let units = ["", "Thousand", "Million", "Billion"];
        while num > 0 {
            let mut n = num % 1000;
            num /= 1000;
            tmp.clear();
            if n > 99 {
                tmp.push_str(Self::under_20(n / 100));
                tmp.push_str(" Hundred");
                n %= 100;
            }
            if n > 19 {
                tmp.push_str(Self::tens(n / 10));
                n %= 10;
            }
            if n > 0 {
                tmp.push_str(Self::under_20(n));
            }
            if !tmp.is_empty() {
                if !result.is_empty() {
                    result.insert_str(0, " ");
                }
                result.insert_str(0, tmp.as_str());
                if i > 0 {
                    result.insert_str(0, " ");
                    result.insert_str(0, units[i]);
                }
            }
            i += 1;
        }
        result
    }
    fn under_20(n: i32) -> &'static str {
        match n {
            1 => "One",
            2 => "Two",
            3 => "Three",
            4 => "Four",
            5 => "Five",
            6 => "Six",
            7 => "Seven",
            8 => "Eight",
            9 => "Nine",
            10 => "Ten",
            11 => "Eleven",
            12 => "Twelve",
            13 => "Thirteen",
            14 => "Fourteen",
            15 => "Fifteen",
            16 => "Sixteen",
            17 => "Seventeen",
            18 => "Eighteen",
            19 => "Nineteen",
            _ => "",
        }
    }
}