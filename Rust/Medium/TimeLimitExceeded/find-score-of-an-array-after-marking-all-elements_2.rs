impl Solution {
    pub fn find_score(nums: Vec<i32>) -> i64 {
        
        let mut nums = nums;
        let mut score = 0i64;
        let mut i = 0usize;
        while i < nums.len() {
            if nums[i] == -1 {
                i += 1;
                continue;
            }
            let mut min = nums[i];
            let mut min_i = i;
            let mut j = i + 1;
            while j < nums.len() {
                if nums[j] != -1 && nums[j] < min {
                    min = nums[j];
                    min_i = j;
                }
                j += 1;
            }
            score += min as i64;
            nums[min_i] = -1;
            if min_i > 0 {
                nums[min_i - 1] = -1;
            }
            if min_i < nums.len() - 1 {
                nums[min_i + 1] = -1;
            }
        }
        score
    }
}