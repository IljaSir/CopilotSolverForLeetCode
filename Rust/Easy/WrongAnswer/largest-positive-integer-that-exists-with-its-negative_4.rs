impl Solution {
    pub fn find_max_k(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        for i in 0..nums.len() {
            if nums[i].abs() > max {
                max = nums[i].abs();
            }
        }
        let mut hash = vec![0; max as usize + 1];
        for i in 0..nums.len() {
            if nums[i] > 0 {
                hash[nums[i] as usize] = 1;
            }
        }
        for i in (1..hash.len()).rev() {
            if hash[i] == 1 && hash[hash.len() - i] == 1 {
                return i as i32;
            }
        }
        return -1;
    }
}