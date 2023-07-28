impl Solution {
    pub fn optimal_division(nums: Vec<i32>) -> String {
        

        nums.iter().enumerate().map(|(i, &n)| {
            if i == 0 {
                n.to_string()
            } else if i == 1 && nums.len() == 2 {
                format!("{}/{}", n, nums[0])
            } else {
                format!("({})", n)
            }
        }).collect::<Vec<String>>().join("/")
    }
}