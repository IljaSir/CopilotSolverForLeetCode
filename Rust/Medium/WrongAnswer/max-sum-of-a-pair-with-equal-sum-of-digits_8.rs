impl Solution {
    pub fn maximum_sum(nums: Vec<i32>) -> i32 {
        
        let mut sum = -1;
        let mut max = -1;
        let mut max2 = -1;
        for i in 0..nums.len() {
            sum = 0;
            let mut n = nums[i];
            while n > 0 {
                sum += n % 10;
                n /= 10;
            }
            if sum > max {
                max2 = max;
                max = sum;
            } else if sum > max2 {
                max2 = sum;
            }
        }
        if max == max2 {
            return -1;
        }
        for i in 0..nums.len() {
            sum = 0;
            let mut n = nums[i];
            while n > 0 {
                sum += n % 10;
                n /= 10;
            }
            if sum == max {
                for j in 0..nums.len() {
                    if i == j {
                        continue;
                    }
                    sum = 0;
                    let mut n = nums[j];
                    while n > 0 {
                        sum += n % 10;
                        n /= 10;
                    }
                    if sum == max2 {
                        return nums[i] + nums[j];
                    }
                }
            }
        }
        -1
    }
}