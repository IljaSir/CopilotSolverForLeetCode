impl Solution {
    pub fn num_of_pairs(nums: Vec<String>, target: String) -> i32 {
        
        let mut ans = 0;
        for i in 0..nums.len() {
            for j in 0..nums.len() {
                if i != j && nums[i].to_owned() + &nums[j].to_owned() == target {
                    ans += 1;
                }
            }
        }
        ans
    }
}