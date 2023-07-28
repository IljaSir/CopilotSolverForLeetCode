impl Solution {
    pub fn sub_array_ranges(nums: Vec<i32>) -> i64 {
        
        let mut sum = 0;
        let n = nums.len();
        for i in 0..n {
            let mut min = nums[i];
            let mut max = nums[i];
            for j in i..n {
                min = min.min(nums[j]);
                max = max.max(nums[j]);
                sum += (max - min) as i64;
            }
        }
        sum
    }
}