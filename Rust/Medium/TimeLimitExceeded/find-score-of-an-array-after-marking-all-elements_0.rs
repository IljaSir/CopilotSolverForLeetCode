impl Solution {
    pub fn find_score(nums: Vec<i32>) -> i64 {
        
        let mut nums = nums;
        let mut score = 0;
        let mut i = 0;
        while i < nums.len() {
            if nums[i] == 0 {
                i += 1;
                continue;
            }
            let mut min = nums[i];
            let mut min_index = i;
            for j in i..nums.len() {
                if nums[j] == 0 {
                    continue;
                }
                if nums[j] < min {
                    min = nums[j];
                    min_index = j;
                }
            }
            score += min as i64;
            nums[min_index] = 0;
            if min_index > 0 {
                nums[min_index - 1] = 0;
            }
            if min_index < nums.len() - 1 {
                nums[min_index + 1] = 0;
            }
        }
        score
    }
}