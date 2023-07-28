impl Solution {
    pub fn sum_four_divisors(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        for num in nums {
            let mut count = 0;
            let mut sum_divisors = 0;
            for i in 1..=num {
                if num % i == 0 {
                    count += 1;
                    sum_divisors += i;
                }
            }
            if count == 4 {
                sum += sum_divisors;
            }
        }
        sum
    }
}