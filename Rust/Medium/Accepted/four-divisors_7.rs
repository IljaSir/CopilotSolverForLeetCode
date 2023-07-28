impl Solution {
    pub fn sum_four_divisors(nums: Vec<i32>) -> i32 {
        
        let mut res = 0;
        for i in nums {
            let mut count = 2;
            let mut sum = 1 + i;
            for j in 2..i {
                if j * j > i {
                    break;
                }
                if i % j == 0 {
                    count += 1;
                    sum += j;
                    if j * j != i {
                        count += 1;
                        sum += i / j;
                    }
                }
                if count > 4 {
                    break;
                }
            }
            if count == 4 {
                res += sum;
            }
        }
        res
    }
}