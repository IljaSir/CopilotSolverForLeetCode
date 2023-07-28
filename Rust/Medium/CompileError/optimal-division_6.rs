impl Solution {
    pub fn optimal_division(nums: Vec<i32>) -> String {
        

        let nums = nums.iter().map(|x| x.to_string()).collect::<Vec<String>>();
        let mut res = nums[0].clone();
        if nums.len() == 1 {
            return res;
        }
        if nums.len() == 2 {
            return res + "/" + &nums[1];
        }
        res += "/(" + &nums[1];
        for i in 2..nums.len() {
            res += "/" + &nums[i];
        }
        res += ")";
        res
    }
}