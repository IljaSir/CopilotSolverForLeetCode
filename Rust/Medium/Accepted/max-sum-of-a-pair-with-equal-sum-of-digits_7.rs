impl Solution {
    pub fn maximum_sum(nums: Vec<i32>) -> i32 {
        
        let mut max = -1;
        let mut max_digit = [0; 100];
        for num in nums {
            let mut digit = 0;
            let mut n = num;
            while n > 0 {
                digit += n % 10;
                n /= 10;
            }
            let index = digit as usize;
            if max_digit[index] > 0 {
                let sum = max_digit[index] + num;
                if sum > max {
                    max = sum;
                }
            }
            if num > max_digit[index] {
                max_digit[index] = num;
            }
        }
        max
    }
}