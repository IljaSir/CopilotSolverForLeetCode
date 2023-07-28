impl Solution {
    pub fn largest_number(nums: Vec<i32>) -> String {
        

        let mut nums = nums;
        nums.sort_by(|a, b| {
            let a = a.to_string();
            let b = b.to_string();
            let ab = a.clone() + &b;
            let ba = b + &a;
            ab.cmp(&ba)
        });
        let mut result = String::new();
        for i in nums.iter().rev() {
            result += &i.to_string();
        }
        result = result.trim_start_matches("0").to_string();
        if result.is_empty() {
            "0".to_string()
        } else {
            result
        }
    }
}