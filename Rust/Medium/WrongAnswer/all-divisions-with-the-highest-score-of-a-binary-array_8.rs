impl Solution {
    pub fn max_score_indices(nums: Vec<i32>) -> Vec<i32> {
        
        let mut n = nums.len();
        let mut result = vec![];
        let mut max_score = 0;
        let mut score = 0;
        for i in 0..n {
            if nums[i] == 0 {
                score += 1;
            }
        }
        max_score = score;
        for i in 0..n {
            if nums[i] == 0 {
                score -= 1;
            } else {
                score += 1;
            }
            if score > max_score {
                max_score = score;
                result.clear();
                result.push(i as i32 + 1);
            } else if score == max_score {
                result.push(i as i32 + 1);
            }
        }
        result
    }
}