impl Solution {
    pub fn kth_largest_number(nums: Vec<String>, k: i32) -> String {
        
        let mut nums: Vec<i32> = nums.iter().map(|s| s.parse::<i32>().unwrap()).collect();
        nums.sort();
        nums.reverse();
        nums[k as usize - 1].to_string()
    }
}