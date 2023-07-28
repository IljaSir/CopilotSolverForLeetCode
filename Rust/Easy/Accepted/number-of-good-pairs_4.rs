impl Solution {
    pub fn num_identical_pairs(nums: Vec<i32>) -> i32 {
        
        let mut cnt = 0;
        for i in 0..nums.len() {
            for j in i+1..nums.len() {
                if nums[i] == nums[j] {
                    cnt += 1;
                }
            }
        }
        cnt
    }
}