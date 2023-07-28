impl Solution {
    pub fn int_to_roman(num: i32) -> String {
        

        let mut n = num;
        let mut ans = String::new();
        let mut roman = vec![
            ("M", 1000),
            ("CM", 900),
            ("D", 500),
            ("CD", 400),
            ("C", 100),
            ("XC", 90),
            ("L", 50),
            ("XL", 40),
            ("X", 10),
            ("IX", 9),
            ("V", 5),
            ("IV", 4),
            ("I", 1),
        ];
        for (roman, value) in roman {
            while n >= *value {
                ans.push_str(roman);
                n -= value;
            }
        }
        ans
    }
}