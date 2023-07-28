impl Solution {
    pub fn int_to_roman(num: i32) -> String {
        

        let mut num = num;
        let mut result = String::new();
        while num != 0 {
            match num {
                1..=3 => {
                    result.push('I');
                    num -= 1;
                }
                4 => {
                    result.push_str("IV");
                    num -= 4;
                }
                5..=8 => {
                    result.push('V');
                    num -= 5;
                }
                9 => {
                    result.push_str("IX");
                    num -= 9;
                }
                10..=39 => {
                    result.push('X');
                    num -= 10;
                }
                40..=49 => {
                    result.push_str("XL");
                    num -= 40;
                }
                50..=89 => {
                    result.push('L');
                    num -= 50;
                }
                90..=99 => {
                    result.push_str("XC");
                    num -= 90;
                }
                100..=399 => {
                    result.push('C');
                    num -= 100;
                }
                400..=499 => {
                    result.push_str("CD");
                    num -= 400;
                }
                500..=899 => {
                    result.push('D');
                    num -= 500;
                }
                900..=999 => {
                    result.push_str("CM");
                    num -= 900;
                }
                1000..=3999 => {
                    result.push('M');
                    num -= 1000;
                }
                _ => unreachable!(),
            }
        }
        result
    }
}