impl Solution {
    pub fn kth_largest_number(nums: Vec<String>, k: i32) -> String {
        
        let mut nums: Vec<i32> = nums.iter().map(|s| s.parse().unwrap()).collect();
        nums.sort_unstable();
        nums[nums.len() - k as usize].to_string()
    }
}