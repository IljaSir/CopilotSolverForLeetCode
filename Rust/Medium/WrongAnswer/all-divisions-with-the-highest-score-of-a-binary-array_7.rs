impl Solution {
    pub fn max_score_indices(nums: Vec<i32>) -> Vec<i32> {
        
        let n = nums.len();
        let mut max = 0;
        let mut res = Vec::new();
        let mut count = 0;
        for i in 0..n {
            if nums[i] == 0 {
                count += 1;
            }
        }
        for i in 0..n {
            if nums[i] == 0 {
                count -= 1;
            }
            if count > max {
                max = count;
                res = vec![i as i32 + 1];
            } else if count == max {
                res.push(i as i32 + 1);
            }
        }
        res
    }
}