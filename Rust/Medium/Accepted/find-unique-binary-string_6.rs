impl Solution {
    pub fn find_different_binary_string(nums: Vec<String>) -> String {
        
        let n = nums.len();
        let mut result = String::with_capacity(n);
        for i in 0..n {
            result.push(if nums[i].chars().nth(i).unwrap() == '1' { '0' } else { '1' });
        }
        result
    }
}