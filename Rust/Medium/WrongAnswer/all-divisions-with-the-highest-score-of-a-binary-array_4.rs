impl Solution {
    pub fn max_score_indices(nums: Vec<i32>) -> Vec<i32> {
        
        let mut sum = 0;
        let mut max = 0;
        let mut res = Vec::new();
        for i in 0..nums.len() {
            if nums[i] == 0 {
                sum += 1;
            } else {
                sum -= 1;
            }
            if sum > max {
                max = sum;
                res.clear();
                res.push(i as i32 + 1);
            } else if sum == max {
                res.push(i as i32 + 1);
            }
        }
        res
    }
}