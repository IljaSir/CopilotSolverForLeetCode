impl Solution {
    pub fn maximum_segment_sum(nums: Vec<i32>, remove_queries: Vec<i32>) -> Vec<i64> {
        
        let n = nums.len();
        let mut set: std::collections::BTreeSet<usize> = std::collections::BTreeSet::new();
        for i in 0..n {
            set.insert(i);
        }
        let mut ans: Vec<i64> = vec![0; n];
        let mut max = 0;
        for i in (0..n).rev() {
            let j = remove_queries[i] as usize;
            let mut sum = 0;
            if let Some(&k) = set.range(j..).next() {
                sum += nums[k] as i64;
                set.remove(&k);
            }
            if let Some(&k) = set.range(..j).rev().next() {
                sum += nums[k] as i64;
                set.remove(&k);
            }
            max = max.max(sum);
            ans[i] = max;
        }
        ans
    }
}