impl Solution {
    pub fn best_rotation(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut diff = vec![0; n];
        for (i, &num) in nums.iter().enumerate() {
            diff[(i as i32 - num + n as i32) as usize % n] -= 1;
        }
        for i in 1..n {
            diff[i] += diff[i - 1] + 1;
        }
        diff.iter().enumerate().max_by_key(|(_, &v)| v).unwrap().0 as i32
    }
}