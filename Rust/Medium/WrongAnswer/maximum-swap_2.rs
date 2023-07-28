impl Solution {
    pub fn maximum_swap(num: i32) -> i32 {
        

        let mut num = num;
        let mut digits = Vec::new();
        while num > 0 {
            digits.push(num % 10);
            num /= 10;
        }
        digits.reverse();
        let mut max = 0;
        let mut max_index = 0;
        for i in 0..digits.len() {
            if digits[i] > max {
                max = digits[i];
                max_index = i;
            }
        }
        for i in 0..digits.len() {
            if digits[i] < max {
                digits.swap(i, max_index);
                break;
            }
        }
        let mut result = 0;
        for digit in digits {
            result = result * 10 + digit;
        }
        result
    }
}