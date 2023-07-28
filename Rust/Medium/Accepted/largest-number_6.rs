impl Solution {
    pub fn largest_number(nums: Vec<i32>) -> String {
        

        let mut nums = nums;
        nums.sort_by(|a, b| {
            let mut sa = a.to_string();
            let mut sb = b.to_string();
            sa.push_str(&sb);
            sb.push_str(&sa);
            sb.cmp(&sa)
        });
        let mut res = String::new();
        for i in nums {
            if i == 0 && res.len() == 0 {
                continue;
            }
            res.push_str(&i.to_string());
        }
        if res.len() == 0 {
            return "0".to_string();
        }
        res
    }
}