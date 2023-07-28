impl Solution {
    pub fn optimal_division(nums: Vec<i32>) -> String {
        

        let mut res = String::new();
        if nums.len() == 1 {
            return res + &nums[0].to_string();
        }
        if nums.len() == 2 {
            return res + &nums[0].to_string() + "/" + &nums[1].to_string();
        }
        res += &nums[0].to_string();
        res += "/(";
        for i in 1..nums.len() {
            res += &nums[i].to_string();
            if i != nums.len() - 1 {
                res += "/";
            }
        }
        res += ")";
        res
    }
}