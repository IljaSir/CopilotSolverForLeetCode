impl Solution {
    pub fn subarrays_div_by_k(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut sum = 0;
        let mut map = vec![0; k as usize];
        map[0] = 1;
        let mut count = 0;
        for i in 0..nums.len() {
            sum += nums[i];
            let index = (sum % k + k) % k;
            count += map[index as usize];
            map[index as usize] += 1;
        }
        count
    }
}