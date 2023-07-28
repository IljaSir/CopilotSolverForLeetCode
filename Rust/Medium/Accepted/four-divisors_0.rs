impl Solution {
    pub fn sum_four_divisors(nums: Vec<i32>) -> i32 {
        
        nums.iter().map(|&n| {
            let mut sum = 0;
            let mut count = 0;
            let mut i = 1;
            while i * i <= n {
                if n % i == 0 {
                    if i * i == n {
                        count += 1;
                        sum += i;
                    } else {
                        count += 2;
                        sum += i;
                        sum += n / i;
                    }
                }
                if count > 4 {
                    break;
                }
                i += 1;
            }
            if count == 4 {
                sum
            } else {
                0
            }
        }).sum()
    }
}