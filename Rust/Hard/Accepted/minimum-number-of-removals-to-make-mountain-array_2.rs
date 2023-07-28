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
        for i in (0..n - 1).rev() {
            for j in (i + 1)..n {
                if nums[i] > nums[j] {
                    r[i] = r[i].max(r[j] + 1);
                }
            }
        }
        let mut ans = n;
        for i in 1..n - 1 {
            if l[i] > 1 && r[i] > 1 {
                ans = ans.min(n - l[i] - r[i] + 1);
            }
        }
        ans as i32
    }
}