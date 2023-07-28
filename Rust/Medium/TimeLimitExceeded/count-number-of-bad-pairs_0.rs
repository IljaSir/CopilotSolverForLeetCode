impl Solution {
    pub fn count_bad_pairs(nums: Vec<i32>) -> i64 {
        
        let mut ans = 0;
        for i in 0..nums.len() {
            for j in i+1..nums.len() {
                if j as i32 - i as i32 != nums[j] - nums[i] {
                    ans += 1;
                }
            }
        }
        ans
    }
}