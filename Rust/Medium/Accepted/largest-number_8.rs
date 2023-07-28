impl Solution {
    pub fn largest_number(nums: Vec<i32>) -> String {
        

        let mut nums: Vec<String> = nums.into_iter().map(|x| x.to_string()).collect();
        nums.sort_by(|a, b| {
            let ab = a.clone() + b;
            let ba = b.clone() + a;
            ba.cmp(&ab)
        });
        let mut res = nums.join("");
        while res.starts_with("0") && res.len() > 1 {
            res.remove(0);
        }
        res
    }
}