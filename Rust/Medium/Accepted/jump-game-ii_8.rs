impl Solution {
    pub fn jump(nums: Vec<i32>) -> i32 {
        

        let mut ans = 0;
        let mut i = 0;
        while i < nums.len() - 1 {
            let mut j = i + 1;
            let mut max = 0;
            let mut max_j = 0;
            while j <= i + nums[i] as usize && j < nums.len() {
                if j == nums.len() - 1 {
                    return ans + 1;
                }
                if j + nums[j] as usize > max {
                    max = j + nums[j] as usize;
                    max_j = j;
                }
                j += 1;
            }
            ans += 1;
            i = max_j;
        }
        ans
    }
}