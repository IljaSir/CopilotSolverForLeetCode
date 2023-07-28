impl Solution {
    pub fn find_different_binary_string(nums: Vec<String>) -> String {
        
        let n = nums.len();
        let mut ans = vec!['0'; n];
        for i in 0..n {
            ans[i] = if nums[i].as_bytes()[i] == '0' as u8 { '1' } else { '0' };
        }
        ans.into_iter().collect()
    }
}