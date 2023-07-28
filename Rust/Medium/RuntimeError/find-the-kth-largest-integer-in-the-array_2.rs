impl Solution {
    pub fn kth_largest_number(nums: Vec<String>, k: i32) -> String {
        
        let mut nums: Vec<i32> = nums.iter().map(|x| x.parse::<i32>().unwrap()).collect();
        nums.sort_unstable();
        nums.reverse();
        nums[k as usize - 1].to_string()
    }
}