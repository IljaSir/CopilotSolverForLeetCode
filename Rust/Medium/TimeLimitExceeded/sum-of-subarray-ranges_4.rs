impl Solution {
    pub fn sub_array_ranges(nums: Vec<i32>) -> i64 {
        
        let mut sum = 0;
        let mut n = nums.len();
        for i in 0..n {
            for j in i..n {
                let mut min = nums[i];
                let mut max = nums[i];
                for k in i..=j {
                    min = min.min(nums[k]);
                    max = max.max(nums[k]);
                }
                sum += (max - min) as i64;
            }
        }
        sum
    }
}