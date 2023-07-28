impl Solution {
    pub fn sum_four_divisors(nums: Vec<i32>) -> i32 {
        
        nums.iter().map(|&x| {
            let mut sum = 0;
            let mut cnt = 0;
            let mut i = 1;
            while i * i <= x {
                if x % i == 0 {
                    sum += i;
                    if i * i != x {
                        sum += x / i;
                    }
                    cnt += 1;
                    if cnt > 4 {
                        break;
                    }
                }
                i += 1;
            }
            if cnt == 4 {
                sum
            } else {
                0
            }
        }).sum()
    }
}