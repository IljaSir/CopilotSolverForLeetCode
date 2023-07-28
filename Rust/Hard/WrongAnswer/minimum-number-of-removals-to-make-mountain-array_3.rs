impl Solution {
    pub fn minimum_mountain_removals(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut l = vec![1; n];
        let mut r = vec![1; n];
        for i in 1..n {
            for j in 0..i {
                if nums[i] > nums[j] {
                    l[i] = l[i].max(l[j] + 1);
                }
            }
        }
        for i in (0..n-1).rev() {
            for j in i+1..n {
                if nums[i] > nums[j] {
                    r[i] = r[i].max(r[j] + 1);
                }
            }
        }
        let mut res = n as i32;
        for i in 1..n-1 {
            res = res.min(n as i32 - l[i] - r[i] + 1);
        }
        res
    }
}