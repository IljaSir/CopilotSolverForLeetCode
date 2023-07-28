impl Solution {
    pub fn find_different_binary_string(nums: Vec<String>) -> String {
        
        let n = nums.len();
        let mut res = String::new();
        for i in 0..n {
            if nums[i] == "0" {
                res.push('1');
            } else {
                res.push('0');
            }
        }
        return res;
    }
}