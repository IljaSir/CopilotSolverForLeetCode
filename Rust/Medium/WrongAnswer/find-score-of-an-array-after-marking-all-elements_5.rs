impl Solution {
    pub fn find_score(nums: Vec<i32>) -> i64 {
        
        let mut score = 0;
        let mut nums = nums;
        let mut i = 0;
        while i < nums.len() {
            if nums[i] > 0 {
                let mut min = nums[i];
                let mut min_index = i;
                if i > 0 && nums[i - 1] > 0 && nums[i - 1] < min {
                    min = nums[i - 1];
                    min_index = i - 1;
                }
                if i < nums.len() - 1 && nums[i + 1] > 0 && nums[i + 1] < min {
                    min = nums[i + 1];
                    min_index = i + 1;
                }
                score += min as i64;
                nums[min_index] = -1;
                if min_index > 0 {
                    nums[min_index - 1] = -1;
                }
                if min_index < nums.len() - 1 {
                    nums[min_index + 1] = -1;
                }
            }
            i += 1;
        }
        score
    }
}