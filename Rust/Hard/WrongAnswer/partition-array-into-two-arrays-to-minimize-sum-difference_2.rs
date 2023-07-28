impl Solution {
    pub fn minimum_difference(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let n = nums.len() / 2;
        let mut res = i32::max_value();
        for i in 0..(1 << n) {
            let mut s1 = 0;
            let mut s2 = 0;
            for j in 0..n {
                if (i & (1 << j)) > 0 {
                    s1 += nums[j];
                } else {
                    s2 += nums[j];
                }
            }
            for j in n..(n * 2) {
                if (i & (1 << (j - n))) > 0 {
                    s2 += nums[j];
                } else {
                    s1 += nums[j];
                }
            }
            res = res.min((s1 - s2).abs());
        }
        res
    }
}