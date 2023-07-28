impl Solution {
    pub fn find_score(nums: Vec<i32>) -> i64 {
        
        let mut nums = nums;
        let mut score = 0;
        let mut marked = vec![false; nums.len()];
        while marked.iter().any(|&x| !x) {
            let mut min = i32::max_value();
            let mut min_index = 0;
            for i in 0..nums.len() {
                if !marked[i] && nums[i] < min {
                    min = nums[i];
                    min_index = i;
                }
            }
            score += min as i64;
            marked[min_index] = true;
            if min_index > 0 {
                marked[min_index - 1] = true;
            }
            if min_index < nums.len() - 1 {
                marked[min_index + 1] = true;
            }
        }
        score
    }
}