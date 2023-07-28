impl Solution {
    pub fn find_different_binary_string(nums: Vec<String>) -> String {
        
        let n = nums.len();
        let mut ans = String::new();
        for i in 0..n {
            ans.push(if nums[i].chars().nth(0).unwrap() == '0' { '1' } else { '0' });
        }
        ans
    }
}