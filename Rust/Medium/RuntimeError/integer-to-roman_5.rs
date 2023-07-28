impl Solution {
    pub fn int_to_roman(num: i32) -> String {
        

        let mut roman = String::new();
        let mut num = num;
        let mut base = 1;
        while num > 0 {
            let digit = num % 10;
            if digit > 0 {
                roman = Self::int_to_roman_digit(digit, base) + &roman;
            }
            num /= 10;
            base *= 10;
        }
        roman
    }

    pub fn int_to_roman_digit(digit: i32, base: i32) -> String {
        let mut roman = String::new();
        if digit == 4 {
            roman.push_str(Self::int_to_roman_digit(1, base).as_str());
            roman.push_str(Self::int_to_roman_digit(5, base).as_str());
        } else if digit == 9 {
            roman.push_str(Self::int_to_roman_digit(1, base).as_str());
            roman.push_str(Self::int_to_roman_digit(10, base).as_str());
        } else {
            if digit >= 5 {
                roman.push_str(Self::int_to_roman_digit(5, base).as_str());
            }
            for _ in 0..(digit % 5) {
                roman.push_str(Self::int_to_roman_digit(1, base).as_str());
            }
        }
        roman
    }
}