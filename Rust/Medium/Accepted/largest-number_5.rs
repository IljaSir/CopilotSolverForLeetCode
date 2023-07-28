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
        let mut res = nums.iter().map(|x| x.to_string()).collect::<String>();
        while res.starts_with("0") {
            res.remove(0);
        }
        if res.is_empty() {
            return "0".to_string();
        }
        res
    }
}