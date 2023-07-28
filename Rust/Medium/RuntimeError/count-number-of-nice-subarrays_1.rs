impl Solution {
    pub fn number_of_subarrays(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut odd = vec![-1];
        for i in 0..nums.len() {
            if nums[i] & 1 == 1 {
                odd.push(i as i32);
            }
        }
        odd.push(nums.len() as i32);
        let mut res = 0;
        for i in 1..odd.len() - k as usize {
            res += (odd[i] - odd[i-1]) * (odd[i+k as usize] - odd[i+k as usize - 1]);
        }
        res
    }
}