impl Solution {
    pub fn sum_four_divisors(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        for num in nums {
            let mut count = 0;
            let mut i = 1;
            let mut sum_div = 0;
            while i * i <= num {
                if num % i == 0 {
                    count += 1;
                    sum_div += i;
                    if i * i != num {
                        count += 1;
                        sum_div += num / i;
                    }
                    if count > 4 {
                        break;
                    }
                }
                i += 1;
            }
            if count == 4 {
                sum += sum_div;
            }
        }
        sum
    }
}