impl Solution {
    pub fn number_of_subarrays(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut res = 0;
        let mut odd = 0;
        let mut odd_pos = vec![-1];
        for (i, &n) in nums.iter().enumerate() {
            if n & 1 == 1 {
                odd += 1;
                odd_pos.push(i as i32);
            }
            if odd >= k {
                res += odd_pos[odd as usize - k as usize + 1] - odd_pos[odd as usize - k as usize] + 1;
            }
        }
        res
    }
}