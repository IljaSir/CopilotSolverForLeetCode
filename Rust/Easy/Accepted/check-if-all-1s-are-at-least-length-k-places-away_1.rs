impl Solution {
    pub fn k_length_apart(nums: Vec<i32>, k: i32) -> bool {
        
        let mut last = -1;
        for i in 0..nums.len() {
            if nums[i] == 1 {
                if last != -1 && i as i32 - last <= k {
                    return false;
                }
                last = i as i32;
            }
        }
        true
    }
}