impl Solution {
    pub fn reformat(s: String) -> String {
        
        let mut chars: Vec<char> = Vec::new();
        let mut nums: Vec<char> = Vec::new();
        for c in s.chars() {
            if c.is_digit(10) {
                nums.push(c);
            } else {
                chars.push(c);
            }
        }
        if (chars.len() as i32 - nums.len() as i32).abs() > 1 {
            return "".to_string();
        }
        let mut res: Vec<char> = Vec::new();
        if chars.len() > nums.len() {
            let mut i = 0;
            while i < nums.len() {
                res.push(chars[i]);
                res.push(nums[i]);
                i += 1;
            }
            res.push(chars[i]);
        } else if chars.len() < nums.len() {
            let mut i = 0;
            while i < chars.len() {
                res.push(nums[i]);
                res.push(chars[i]);
                i += 1;
            }
            res.push(nums[i]);
        } else {
            let mut i = 0;
            while i < chars.len() {
                res.push(chars[i]);
                res.push(nums[i]);
                i += 1;
            }
        }
        res.iter().collect()
    }
}