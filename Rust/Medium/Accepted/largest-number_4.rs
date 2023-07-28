impl Solution {
    pub fn largest_number(nums: Vec<i32>) -> String {
        

        let mut nums = nums;
        nums.sort_by(|a, b| {
            let a = a.to_string();
            let b = b.to_string();
            let ab = a.clone() + &b;
            let ba = b + &a;
            ba.cmp(&ab)
        });
        let mut res = String::new();
        for n in nums {
            res += &n.to_string();
        }
        let mut res = res.trim_start_matches('0').to_string();
        if res.len() == 0 {
            res = "0".to_string();
        }
        res
    }
}