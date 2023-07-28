impl Solution {
    pub fn moves_to_make_zigzag(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        let mut i = 1;
        let mut n = 0;
        while i < nums.len() {
            if nums[i] >= nums[i-1] {
                n += nums[i] - nums[i-1] + 1;
                nums[i] = nums[i-1] - 1;
            }
            i += 1;
        }
        let mut i = 0;
        let mut m = 0;
        while i < nums.len()-1 {
            if nums[i] >= nums[i+1] {
                m += nums[i] - nums[i+1] + 1;
                nums[i] = nums[i+1] - 1;
            }
            i += 1;
        }
        n.min(m)
    }
}