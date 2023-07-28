impl Solution {
    pub fn sort_array_by_parity_ii(nums: Vec<i32>) -> Vec<i32> {
        
        let mut result = vec![0; nums.len()];
        let mut j = 0;
        let mut k = 1;
        for i in 0..nums.len() {
            if nums[i] % 2 == 0 {
                result[j] = nums[i];
                j += 2;
            } else {
                result[k] = nums[i];
                k += 2;
            }
        }
        result
    }
}