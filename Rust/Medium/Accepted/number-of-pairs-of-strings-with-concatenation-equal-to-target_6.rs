impl Solution {
    pub fn num_of_pairs(nums: Vec<String>, target: String) -> i32 {
        
        let mut count = 0;
        for i in 0..nums.len() {
            for j in 0..nums.len() {
                if i == j { continue; }
                let mut s = String::new();
                s.push_str(&nums[i]);
                s.push_str(&nums[j]);
                if s == target {
                    count += 1;
                }
            }
        }
        return count;
    }
}