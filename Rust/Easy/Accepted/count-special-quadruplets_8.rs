impl Solution {
    pub fn count_quadruplets(nums: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let n = nums.len();
        for i in 0..n-3 {
            for j in i+1..n-2 {
                for k in j+1..n-1 {
                    for l in k+1..n {
                        if nums[i] + nums[j] + nums[k] == nums[l] {
                            res += 1;
                        }
                    }
                }
            }
        }
        res
    }
}