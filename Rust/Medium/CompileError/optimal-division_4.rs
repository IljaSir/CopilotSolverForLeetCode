impl Solution {
    pub fn optimal_division(nums: Vec<i32>) -> String {
        

        let mut s = String::new();
        match nums.len() {
            0 => s,
            1 => s.push_str(&nums[0].to_string()),
            2 => {
                s.push_str(&nums[0].to_string());
                s.push('/');
                s.push_str(&nums[1].to_string());
            }
            _ => {
                s.push_str(&nums[0].to_string());
                s.push_str("/(");
                for i in 1..nums.len() {
                    s.push_str(&nums[i].to_string());
                    if i != nums.len() - 1 {
                        s.push('/');
                    }
                }
                s.push(')');
            }
        }
        s
    }
}