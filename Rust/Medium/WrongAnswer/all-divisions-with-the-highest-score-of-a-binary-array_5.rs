impl Solution {
    pub fn max_score_indices(nums: Vec<i32>) -> Vec<i32> {
        
        let mut max = 0;
        let mut res = Vec::new();
        let mut sum = 0;
        for i in 0..nums.len() {
            if nums[i] == 1 {
                sum += 1;
            }
        }
        let mut left = 0;
        for i in 0..nums.len() {
            if nums[i] == 1 {
                sum -= 1;
            } else {
                left += 1;
            }
            let score = left + sum;
            if score > max {
                res.clear();
                res.push(i as i32);
                max = score;
            } else if score == max {
                res.push(i as i32);
            }
        }
        res
    }
}