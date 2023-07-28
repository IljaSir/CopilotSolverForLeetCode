impl Solution {
    pub fn minimum_deviation(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut ans = i32::max_value();
        let mut max = nums[nums.len()-1];
        for i in 0..nums.len() {
            if nums[i] % 2 == 1 {
                nums[i] *= 2;
            }
            max = nums[i].max(max);
        }
        let mut min = i32::max_value();
        for i in 0..nums.len() {
            min = nums[i].min(min);
            ans = ans.min(max - min);
            if nums[i] % 2 == 0 {
                nums[i] /= 2;
                max = nums[i].max(max);
            }
        }
        ans
    }
}