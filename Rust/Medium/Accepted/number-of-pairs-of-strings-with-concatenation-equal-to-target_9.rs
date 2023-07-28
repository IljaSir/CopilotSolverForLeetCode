impl Solution {
    pub fn num_of_pairs(nums: Vec<String>, target: String) -> i32 {
        
        let mut count = 0;
        let mut map: std::collections::HashMap<String, i32> = std::collections::HashMap::new();
        for i in 0..nums.len() {
            for j in 0..nums.len() {
                if i != j {
                    let mut s = String::new();
                    s.push_str(&nums[i]);
                    s.push_str(&nums[j]);
                    if s == target {
                        count += 1;
                    }
                }
            }
        }
        count
    }
}