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
        let mut ans = nums
            .into_iter()
            .map(|x| x.to_string())
            .collect::<Vec<String>>()
            .join("");
        if ans.chars().next().unwrap() == '0' {
            ans = "0".to_string()
        }
        ans
    }
}