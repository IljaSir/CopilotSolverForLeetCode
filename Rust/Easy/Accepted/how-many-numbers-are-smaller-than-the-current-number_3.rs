impl Solution {
    pub fn smaller_numbers_than_current(nums: Vec<i32>) -> Vec<i32> {
        
        let mut ans = vec![0; nums.len()];
        for i in 0..nums.len() {
            for j in 0..nums.len() {
                if i != j && nums[i] > nums[j] {
                    ans[i] += 1;
                }
            }
        }
        ans
    }
}