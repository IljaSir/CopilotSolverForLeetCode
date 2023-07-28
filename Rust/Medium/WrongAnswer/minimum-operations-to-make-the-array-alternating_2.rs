impl Solution {
    pub fn minimum_operations(nums: Vec<i32>) -> i32 {
        
        let mut even = 0;
        let mut odd = 0;
        for i in 0..nums.len() {
            if i % 2 == 0 {
                if nums[i] % 2 == 0 {
                    even += 1;
                }
            } else {
                if nums[i] % 2 == 1 {
                    odd += 1;
                }
            }
        }
        let mut ans = even.max(odd);
        even = 0;
        odd = 0;
        for i in 0..nums.len() {
            if i % 2 == 0 {
                if nums[i] % 2 == 1 {
                    even += 1;
                }
            } else {
                if nums[i] % 2 == 0 {
                    odd += 1;
                }
            }
        }
        ans = ans.min(even.max(odd));
        ans
    }
}