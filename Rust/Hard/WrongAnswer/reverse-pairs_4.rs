impl Solution {
    pub fn reverse_pairs(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums.clone();
        let mut cnt = 0;
        let mut i = 0;
        while i < nums.len() {
            let mut j = i + 1;
            while j < nums.len() {
                if nums[i] > 2 * nums[j] {
                    cnt += 1;
                }
                j += 1;
            }
            i += 1;
        }
        cnt
    }
}