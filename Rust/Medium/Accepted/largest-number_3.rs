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
        let mut res = "".to_string();
        for i in nums {
            res += &i.to_string();
        }
        if res.chars().next().unwrap() == '0' {
            return "0".to_string();
        }
        res
    }
}