impl Solution {
    pub fn int_to_roman(num: i32) -> String {
        

        let mut res = String::new();
        let mut num = num;
        let mut digit = 1;
        while num > 0 {
            let v = num % 10;
            res = Self::get_roman(v, digit) + &res;
            num /= 10;
            digit *= 10;
        }
        res
    }
    
    pub fn get_roman(num: i32, digit: i32) -> String {
        match digit {
            1 => {
                match num {
                    1 => "I".to_string(),
                    2 => "II".to_string(),
                    3 => "III".to_string(),
                    4 => "IV".to_string(),
                    5 => "V".to_string(),
                    6 => "VI".to_string(),
                    7 => "VII".to_string(),
                    8 => "VIII".to_string(),
                    9 => "IX".to_string(),
                    _ => "".to_string(),
                }
            },
            10 => {
                match num {
                    1 => "X".to_string(),
                    2 => "XX".to_string(),
                    3 => "XXX".to_string(),
                    4 => "XL".to_string(),
                    5 => "L".to_string(),
                    6 => "LX".to_string(),
                    7 => "LXX".to_string(),
                    8 => "LXXX".to_string(),
                    9 => "XC".to_string(),
                    _ => "".to_string(),
                }
            },
            100 => {
                match num {
                    1 => "C".to_string(),
                    2 => "CC".to_string(),
                    3 => "CCC".to_string(),
                    4 => "CD".to_string(),
                    5 => "D".to_string(),
                    6 => "DC".to_string(),
                    7 => "DCC".to_string(),
                    8 => "DCCC".to_string(),
                    9 => "CM".to_string(),
                    _ => "".to_string(),
                }
            },
            1000 => {
                match num {
                    1 => "M".to_string(),
                    2 => "MM".to_string(),
                    3 => "MMM".to_string(),
                    _ => "".to_string(),
                }
            },
            _ => "".to_string(),
        }
    }
}