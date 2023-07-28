impl Solution {
    pub fn optimal_division(nums: Vec<i32>) -> String {
        

        if nums.len() == 1 {
            return nums[0].to_string();
        }
        if nums.len() == 2 {
            return format!("{}/{}", nums[0], nums[1]);
        }
        let mut res = String::new();
        res.push_str(&format!("{}/(", nums[0]));
        for i in 1..nums.len() - 1 {
            res.push_str(&format!("{}/", nums[i]));
        }
        res.push_str(&format!("{})", nums[nums.len() - 1]));
        res
    }
}