impl Solution {
    pub fn int_to_roman(num: i32) -> String {
        

        let mut ans = String::new();
        let mut num = num;
        let mut i = 0;
        let mut tmp = 0;
        let mut t = 0;
        let mut s = String::new();
        while num > 0 {
            tmp = num % 10;
            num = num / 10;
            if tmp == 0 {
                i += 1;
                continue;
            }
            s = match i {
                0 => match tmp {
                    1 => "I",
                    2 => "II",
                    3 => "III",
                    4 => "IV",
                    5 => "V",
                    6 => "VI",
                    7 => "VII",
                    8 => "VIII",
                    9 => "IX",
                    _ => "",
                },
                1 => match tmp {
                    1 => "X",
                    2 => "XX",
                    3 => "XXX",
                    4 => "XL",
                    5 => "L",
                    6 => "LX",
                    7 => "LXX",
                    8 => "LXXX",
                    9 => "XC",
                    _ => "",
                },
                2 => match tmp {
                    1 => "C",
                    2 => "CC",
                    3 => "CCC",
                    4 => "CD",
                    5 => "D",
                    6 => "DC",
                    7 => "DCC",
                    8 => "DCCC",
                    9 => "CM",
                    _ => "",
                },
                3 => match tmp {
                    1 => "M",
                    2 => "MM",
                    3 => "MMM",
                    _ => "",
                },
                _ => "",
            };
            ans = format!("{}{}", s, ans);
            i += 1;
        }
        ans
    }
}