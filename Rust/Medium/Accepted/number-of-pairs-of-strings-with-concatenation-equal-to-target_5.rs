impl Solution {
    pub fn num_of_pairs(nums: Vec<String>, target: String) -> i32 {
        
        let mut count = 0;
        for (i, n) in nums.iter().enumerate() {
            for (j, m) in nums.iter().enumerate() {
                if i != j && n.len() + m.len() == target.len() {
                    let mut s = String::new();
                    s.push_str(n);
                    s.push_str(m);
                    if s == target {
                        count += 1;
                    }
                }
            }
        }
        count
    }
}