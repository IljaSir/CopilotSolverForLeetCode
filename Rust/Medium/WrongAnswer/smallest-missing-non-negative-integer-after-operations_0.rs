impl Solution {
    pub fn find_smallest_integer(nums: Vec<i32>, value: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut sum = 0;
        for i in 0..nums.len() {
            sum += nums[i];
            if sum + value * (i as i32 + 1) < 0 {
                return i as i32 + 1;
            }
        }
        nums.len() as i32
    }
}