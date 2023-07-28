impl Solution {
    pub fn find_score(nums: Vec<i32>) -> i64 {
        
        let mut nums = nums;
        let mut score = 0;
        let mut marked = vec![false; nums.len()];
        loop {
            let mut min = std::i32::MAX;
            let mut index = 0;
            for i in 0..nums.len() {
                if !marked[i] && nums[i] < min {
                    min = nums[i];
                    index = i;
                }
            }
            if min == std::i32::MAX {
                break;
            }
            marked[index] = true;
            if index > 0 {
                marked[index - 1] = true;
            }
            if index + 1 < nums.len() {
                marked[index + 1] = true;
            }
            score += min as i64;
        }
        score
    }
}