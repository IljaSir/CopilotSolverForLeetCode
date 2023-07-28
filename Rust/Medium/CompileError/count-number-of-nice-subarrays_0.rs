impl Solution {
    pub fn number_of_subarrays(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut odd = Vec::new();
        odd.push(-1);
        for i in 0..nums.len() {
            if nums[i] % 2 == 1 {
                odd.push(i as i32);
            }
        }
        odd.push(nums.len() as i32);
        let mut ans = 0;
        for i in 1..(odd.len() - k) {
            ans += (odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
        }
        ans
    }
}