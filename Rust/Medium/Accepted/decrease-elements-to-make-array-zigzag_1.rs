impl Solution {
    pub fn moves_to_make_zigzag(nums: Vec<i32>) -> i32 {
        
        let mut odd = 0;
        let mut even = 0;
        let n = nums.len();
        for i in 0..n {
            let l = if i == 0 { 1001 } else { nums[i - 1] };
            let r = if i == n - 1 { 1001 } else { nums[i + 1] };
            if i % 2 == 0 {
                if nums[i] >= l.min(r) {
                    even += nums[i] - l.min(r) + 1;
                }
            } else {
                if nums[i] >= l.min(r) {
                    odd += nums[i] - l.min(r) + 1;
                }
            }
        }
        odd.min(even)
    }
}