impl Solution {
    pub fn count_quadruplets(nums: Vec<i32>) -> i64 {
        
        let n = nums.len();
        let mut ans = 0;
        for i in 0..n {
            for j in i+1..n {
                for k in j+1..n {
                    for l in k+1..n {
                        if nums[i] < nums[k] && nums[k] < nums[j] && nums[j] < nums[l] {
                            ans += 1;
                        }
                    }
                }
            }
        }
        ans
    }
}