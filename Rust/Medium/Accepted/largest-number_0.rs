impl Solution {
    pub fn largest_number(nums: Vec<i32>) -> String {
        

        let mut nums = nums;
        nums.sort_by(|a, b| {
            let s1 = format!("{}{}", a, b);
            let s2 = format!("{}{}", b, a);
            s2.cmp(&s1)
        });
        let mut res = String::new();
        let mut zero = true;
        for num in nums {
            if zero && num == 0 {
                continue;
            }
            zero = false;
            res.push_str(&num.to_string());
        }
        if zero {
            res.push('0');
        }
        res
    }
}