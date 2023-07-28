impl Solution {
    pub fn single_number(nums: Vec<i32>) -> Vec<i32> {
        

        let mut result = vec![0, 0];
        let mut x = 0;
        for i in 0..nums.len() {
            x ^= nums[i];
        }
        let mut mask = 1;
        while (x & mask) == 0 {
            mask <<= 1;
        }
        for i in 0..nums.len() {
            if (nums[i] & mask) == 0 {
                result[0] ^= nums[i];
            } else {
                result[1] ^= nums[i];
            }
        }
        result
    }
}