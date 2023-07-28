impl Solution {
    pub fn smallest_number(num: i64) -> i64 {
        
        let mut num = num;
        let mut negative = false;
        if num < 0 {
            negative = true;
            num = -num;
        }
        let mut digits = vec![];
        while num > 0 {
            digits.push(num % 10);
            num /= 10;
        }
        digits.sort();
        let mut result = 0;
        for i in digits.iter() {
            result = result * 10 + i;
        }
        if negative {
            -result
        } else {
            result
        }
    }
}