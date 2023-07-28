impl Solution {
    pub fn maximum_sum(nums: Vec<i32>) -> i32 {
        
        let mut max = -1;
        for i in 0..nums.len() {
            for j in i+1..nums.len() {
                let mut sum1 = 0;
                let mut sum2 = 0;
                let mut t = nums[i];
                while t > 0 {
                    sum1 += t % 10;
                    t /= 10;
                }
                t = nums[j];
                while t > 0 {
                    sum2 += t % 10;
                    t /= 10;
                }
                if sum1 == sum2 {
                    max = max.max(nums[i] + nums[j]);
                }
            }
        }
        max
    }
}