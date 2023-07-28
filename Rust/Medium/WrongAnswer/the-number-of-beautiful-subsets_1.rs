impl Solution {
    pub fn beautiful_subsets(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut ans = 0;
        let n = nums.len();
        for i in 0..1 << n {
            let mut ok = true;
            for j in 0..n {
                for l in j + 1..n {
                    if (i >> j & 1) == 1 && (i >> l & 1) == 1 && (nums[j] - nums[l]).abs() == k {
                        ok = false;
                    }
                }
            }
            if ok {
                ans += 1;
            }
        }
        ans
    }
}