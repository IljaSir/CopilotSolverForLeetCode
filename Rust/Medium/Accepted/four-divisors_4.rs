impl Solution {
    pub fn sum_four_divisors(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        for n in nums {
            let mut count = 0;
            let mut divisors = 0;
            let mut i = 1;
            while i * i <= n {
                if n % i == 0 {
                    count += 1;
                    divisors += i;
                    if i * i != n {
                        count += 1;
                        divisors += n / i;
                    }
                }
                i += 1;
            }
            if count == 4 {
                sum += divisors;
            }
        }
        sum
    }
}