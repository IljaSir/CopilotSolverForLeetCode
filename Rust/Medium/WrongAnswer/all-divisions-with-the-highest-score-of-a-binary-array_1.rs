impl Solution {
    pub fn max_score_indices(nums: Vec<i32>) -> Vec<i32> {
        
        let mut left_zeroes = 0;
        let mut right_ones = nums.iter().filter(|&&x| x == 1).count();
        let mut max_score = left_zeroes + right_ones;
        let mut max_indices = vec![0];
        for i in 1..nums.len() {
            if nums[i - 1] == 0 {
                left_zeroes += 1;
            } else {
                right_ones -= 1;
            }
            let score = left_zeroes + right_ones;
            if score > max_score {
                max_score = score;
                max_indices.clear();
                max_indices.push(i as i32);
            } else if score == max_score {
                max_indices.push(i as i32);
            }
        }
        max_indices
    }
}