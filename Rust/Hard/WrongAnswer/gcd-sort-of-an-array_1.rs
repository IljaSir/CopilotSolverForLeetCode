impl Solution {
    pub fn gcd_sort(nums: Vec<i32>) -> bool {
        
        let mut nums = nums;
        nums.sort();
        for i in 0..nums.len() {
            if nums[i] != nums[i] {
                return false;
            }
        }
        true
    }
}