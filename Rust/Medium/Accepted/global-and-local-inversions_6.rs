impl Solution {
    pub fn is_ideal_permutation(nums: Vec<i32>) -> bool {
        
        let mut local = 0;
        let mut global = 0;
        for i in 0..nums.len() {
            if i > 0 && nums[i - 1] > nums[i] {
                local += 1;
            }
            for j in i + 1..nums.len() {
                if nums[i] > nums[j] {
                    global += 1;
                }
            }
        }
        local == global
    }
}