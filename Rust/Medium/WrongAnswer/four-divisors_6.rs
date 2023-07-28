impl Solution {
    pub fn sum_four_divisors(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        for num in nums {
            let mut count = 0;
            let mut sum_of_divisors = 0;
            let mut i = 1;
            while i * i <= num {
                if num % i == 0 {
                    if i * i == num {
                        sum_of_divisors += i;
                    } else {
                        sum_of_divisors += i + num / i;
                    }
                    count += 1;
                }
                if count > 4 {
                    break;
                }
                i += 1;
            }
            if count == 4 {
                sum += sum_of_divisors;
            }
        }
        sum
    }
}