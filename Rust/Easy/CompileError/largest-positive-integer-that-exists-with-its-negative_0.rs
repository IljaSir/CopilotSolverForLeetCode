impl Solution {
    pub fn find_max_k(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        for i in 0..nums.len() {
            if nums[i].abs() > max {
                max = nums[i].abs();
            }
        }
        let mut count = vec![0; (max + 1) as usize];
        for i in 0..nums.len() {
            let index = nums[i].abs() as usize;
            count[index] += 1;
        }
        for i in (1..count.len()).rev() {
            if count[i] > 0 && count[i as i32 * -1] > 0 {
                return i as i32;
            }
        }
        -1
    }
}