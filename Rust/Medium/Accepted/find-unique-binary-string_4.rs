impl Solution {
    pub fn find_different_binary_string(nums: Vec<String>) -> String {
        
        let n = nums.len();
        let mut res = String::new();
        for i in 0..n {
            res.push(if nums[i].chars().nth(i).unwrap() == '1' { '0' } else { '1' });
        }
        res
    }
}