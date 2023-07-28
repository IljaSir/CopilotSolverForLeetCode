impl Solution {
    pub fn max_score_indices(nums: Vec<i32>) -> Vec<i32> {
        
        let mut max_score = 0;
        let mut max_score_indices = Vec::new();
        let mut left_zero_count = 0;
        let mut right_one_count = nums.iter().filter(|&x| *x == 1).count();
        for (i, &x) in nums.iter().enumerate() {
            if x == 0 {
                left_zero_count += 1;
            } else {
                right_one_count -= 1;
            }
            let score = left_zero_count + right_one_count;
            if score > max_score {
                max_score = score;
                max_score_indices.clear();
                max_score_indices.push(i as i32 + 1);
            } else if score == max_score {
                max_score_indices.push(i as i32 + 1);
            }
        }
        max_score_indices
    }
}