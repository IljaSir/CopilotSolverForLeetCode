impl Solution {
    pub fn max_score_indices(nums: Vec<i32>) -> Vec<i32> {
        
        let mut res = vec![];
        let mut max = 0;
        let mut cnt = 0;
        let mut ones = vec![0; nums.len()];
        let mut zeros = vec![0; nums.len()];
        for i in 0..nums.len() {
            if nums[i] == 0 {
                cnt += 1;
            }
            zeros[i] = cnt;
        }
        cnt = 0;
        for i in (0..nums.len()).rev() {
            if nums[i] == 1 {
                cnt += 1;
            }
            ones[i] = cnt;
        }
        for i in 0..nums.len() {
            let score = zeros[i] + ones[i];
            if score > max {
                max = score;
                res.clear();
                res.push(i as i32);
            } else if score == max {
                res.push(i as i32);
            }
        }
        res
    }
}