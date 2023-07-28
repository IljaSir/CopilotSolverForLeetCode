impl Solution {
    pub fn sequential_digits(low: i32, high: i32) -> Vec<i32> {
        
        let mut digits = vec![];
        let mut i = 1;
        let mut j = 1;
        let mut num = 0;
        while i <= 9 {
            num = num * 10 + i;
            j += 1;
            if j == 10 {
                j = 1;
                i += 1;
            }
            if num >= low && num <= high {
                digits.push(num);
            }
        }
        digits
    }
}