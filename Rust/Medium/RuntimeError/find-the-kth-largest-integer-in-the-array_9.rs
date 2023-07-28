impl Solution {
    pub fn kth_largest_number(nums: Vec<String>, k: i32) -> String {
        
        let mut nums = nums;
        nums.sort_by_key(|s| s.len());
        nums.reverse();
        nums.sort_by_key(|s| s.parse::<i32>().unwrap());
        nums.reverse();
        nums[k as usize - 1].to_string()
    }
}