impl Solution {
    pub fn min_cost(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut count = vec![0; nums.len()];
        for &n in &nums {
            count[n as usize] += 1;
        }
        let mut cost = 0;
        let mut cur = 0;
        for i in 0..nums.len() {
            if count[nums[i] as usize] > 1 {
                cur += 1;
            } else {
                cost += cur;
                cur = 0;
            }
        }
        cost += cur;
        cost as i32 * k
    }
}