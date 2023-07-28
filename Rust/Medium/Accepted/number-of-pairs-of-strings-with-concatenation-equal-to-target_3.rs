impl Solution {
    pub fn num_of_pairs(nums: Vec<String>, target: String) -> i32 {
        
        let mut res = 0;
        for i in 0..nums.len() {
            for j in 0..nums.len() {
                if i == j { continue; }
                if nums[i].to_string() + &nums[j] == target {
                    res += 1;
                }
            }
        }
        res
    }
}