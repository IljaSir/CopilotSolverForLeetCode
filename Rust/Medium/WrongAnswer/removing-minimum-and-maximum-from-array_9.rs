impl Solution {
    pub fn minimum_deletions(nums: Vec<i32>) -> i32 {
        
        let (mut min,mut max)=(0,0);
        let (mut min_val,mut max_val)=(nums[0],nums[0]);
        for i in 1..nums.len() {
            if nums[i] < min_val {
                min += 1;
                min_val = nums[i];
            }
            if nums[i] > max_val {
                max += 1;
                max_val = nums[i];
            }
        }
        min.min(max)
    }
}