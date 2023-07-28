impl Solution {
    pub fn reformat(s: String) -> String {
        
        let mut chars = Vec::new();
        let mut nums = Vec::new();
        let mut res = String::new();
        for c in s.chars() {
            if c.is_alphabetic() {
                chars.push(c);
            } else {
                nums.push(c);
            }
        }
        if (chars.len() as i32 - nums.len() as i32).abs() > 1 {
            return "".to_string();
        }
        if chars.len() >= nums.len() {
            for i in 0..nums.len() {
                res.push(chars[i]);
                res.push(nums[i]);
            }
            if chars.len() > nums.len() {
                res.push(chars[chars.len() - 1]);
            }
        } else {
            for i in 0..chars.len() {
                res.push(nums[i]);
                res.push(chars[i]);
            }
            res.push(nums[nums.len() - 1]);
        }
        res
    }
}