impl Solution {
    pub fn find_max_k(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        nums.reverse();
        let mut i = 0;
        while i < nums.len() {
            let j = i + 1;
            while j < nums.len() {
                if nums[i] == -nums[j] {
                    return nums[i];
                }
                j += 1;
            }
            i += 1;
        }
        -1
    }
}