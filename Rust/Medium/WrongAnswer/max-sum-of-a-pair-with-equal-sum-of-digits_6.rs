impl Solution {
    pub fn maximum_sum(nums: Vec<i32>) -> i32 {
        
        let mut max = -1;
        let mut max_digit = [0; 100];
        for n in nums {
            let mut n = n;
            let mut sum = 0;
            while n > 0 {
                sum += n % 10;
                n /= 10;
            }
            max_digit[sum as usize] = max_digit[sum as usize].max(n);
        }
        for i in 0..100 {
            for j in i..100 {
                if i == j {
                    max = max.max(max_digit[i] + max_digit[j]);
                } else {
                    max = max.max(max_digit[i] + max_digit[j]);
                }
            }
        }
        max
    }
}