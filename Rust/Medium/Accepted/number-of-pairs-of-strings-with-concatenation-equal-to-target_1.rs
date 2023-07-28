impl Solution {
    pub fn num_of_pairs(nums: Vec<String>, target: String) -> i32 {
        
        let mut count = 0;
        for i in 0..nums.len() {
            for j in 0..nums.len() {
                if i != j {
                    let s = nums[i].clone() + &nums[j];
                    if s == target {
                        count += 1;
                    }
                }
            }
        }
        count
    }
}