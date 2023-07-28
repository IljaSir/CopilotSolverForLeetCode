impl Solution {
    pub fn largest_number(nums: Vec<i32>) -> String {
        

        let mut nums = nums;
        nums.sort_by(|a, b| {
            let s1 = a.to_string();
            let s2 = b.to_string();
            let s3 = s1.clone() + &s2;
            let s4 = s2 + &s1;
            s4.cmp(&s3)
        });
        let mut res = String::new();
        for i in nums {
            res += &i.to_string();
        }
        while res.len() > 1 && res.starts_with("0") {
            res.remove(0);
        }
        res
    }
}