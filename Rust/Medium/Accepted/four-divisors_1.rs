impl Solution {
    pub fn sum_four_divisors(nums: Vec<i32>) -> i32 {
        
        nums.iter().map(|&x| {
            let mut count = 0;
            let mut sum = 0;
            for i in 1..=(x as f64).sqrt() as i32 {
                if x % i == 0 {
                    count += 1;
                    sum += i;
                    if i * i != x {
                        count += 1;
                        sum += x / i;
                    }
                    if count > 4 {
                        return 0;
                    }
                }
            }
            if count == 4 {
                sum
            } else {
                0
            }
        }).sum()
    }
}