impl Solution {
    pub fn find_max_k(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut max = 0;
        for i in 0..nums.len() {
            if nums[i] < 0 {
                let mut j = i + 1;
                while j < nums.len() && nums[j] < 0 {
                    j += 1;
                }
                if j < nums.len() && nums[j] > 0 && -nums[i] == nums[j] {
                    max = max.max(nums[j]);
                }
            }
        }
        if max == 0 {
            return -1;
        }
        max
    }
}