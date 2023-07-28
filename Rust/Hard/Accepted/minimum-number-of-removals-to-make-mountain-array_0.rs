impl Solution {
    pub fn minimum_mountain_removals(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut lis = vec![1; n];
        let mut lds = vec![1; n];
        for i in 1..n {
            for j in 0..i {
                if nums[i] > nums[j] {
                    lis[i] = lis[i].max(lis[j] + 1);
                }
                if nums[n - 1 - i] > nums[n - 1 - j] {
                    lds[n - 1 - i] = lds[n - 1 - i].max(lds[n - 1 - j] + 1);
                }
            }
        }
        let mut ans = 0;
        for i in 0..n {
            if lis[i] > 1 && lds[i] > 1 {
                ans = ans.max(lis[i] + lds[i] - 1);
            }
        }
        (n as i32) - ans
    }
}