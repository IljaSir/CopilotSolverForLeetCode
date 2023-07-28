impl Solution {
    pub fn add_digits(num: i32) -> i32 {
        
        if num <= 9 {
            return num;
        }
        let mut sum = 0;
        let mut num = num;
        while num > 0 {
            sum += num % 10;
            num /= 10;
        }
        if sum <= 9 {
            return sum;
        }
        return Solution::add_digits(sum);
    }
}