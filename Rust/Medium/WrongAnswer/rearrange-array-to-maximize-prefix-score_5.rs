impl Solution {
    pub fn max_score(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut prefix = vec![0; nums.len()];
        for i in 0..nums.len() {
            prefix[i] = nums[i];
            if i > 0 {
                prefix[i] += prefix[i - 1];
            }
        }
        let mut score = 0;
        for i in 0..nums.len() {
            if prefix[i] > 0 {
                score += 1;
            }
        }
        score
    }
}