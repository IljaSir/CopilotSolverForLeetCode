impl Solution {
    pub fn total_hamming_distance(nums: Vec<i32>) -> i32 {
        

        let mut result = 0;
        for i in 0..32 {
            let mut ones = 0;
            for num in nums.iter() {
                ones += (num >> i) & 1;
            }
            result += ones * (nums.len() as i32 - ones);
        }
        result
    }
}