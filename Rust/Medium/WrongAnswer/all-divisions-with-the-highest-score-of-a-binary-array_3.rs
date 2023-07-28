impl Solution {
    pub fn max_score_indices(nums: Vec<i32>) -> Vec<i32> {
        
        let mut zeros = 0;
        let mut ones = 0;
        let mut max_score = 0;
        let mut max_indices = Vec::new();
        for i in 0..nums.len() {
            if nums[i] == 0 {
                zeros += 1;
            } else {
                ones += 1;
            }
            let score = zeros + ones;
            if score > max_score {
                max_score = score;
                max_indices = Vec::new();
                max_indices.push(i as i32);
            } else if score == max_score {
                max_indices.push(i as i32);
            }
        }
        max_indices
    }
}