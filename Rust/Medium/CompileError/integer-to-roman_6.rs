impl Solution {
    pub fn int_to_roman(num: i32) -> String {
        

        let mut num = num;
        let mut result = String::new();
        let mut i = 0;
        while num > 0 {
            let mut n = num % 10;
            num /= 10;
            if n == 9 {
                result.insert(0, Self::get_roman_char(i, 0));
                result.insert(0, Self::get_roman_char(i, 2));
            } else if n >= 5 {
                result.insert(0, Self::get_roman_char(i, 1));
                n -= 5;
                while n > 0 {
                    result.insert(0, Self::get_roman_char(i, 0));
                    n -= 1;
                }
            } else if n == 4 {
                result.insert(0, Self::get_roman_char(i, 1));
                result.insert(0, Self::get_roman_char(i, 0));
            } else {
                while n > 0 {
                    result.insert(0, Self::get_roman_char(i, 0));
                    n -= 1;
                }
            }
            i += 1;
        }
        result
    }
}