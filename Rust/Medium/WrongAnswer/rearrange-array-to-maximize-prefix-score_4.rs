impl Solution {
    pub fn max_score(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut score = 0;
        let mut sum = 0;
        for i in 0..nums.len() {
            sum += nums[i];
            if sum > 0 {
                score += 1;
            }
        }
        score
    }
}