impl Solution {
    pub fn sub_array_ranges(nums: Vec<i32>) -> i64 {
        
        let mut ans = 0;
        let mut l = 0;
        let mut r = 0;
        let mut s = std::collections::BTreeSet::new();
        for &x in &nums {
            s.insert(x);
            while s.len() >= 2 {
                let min = *s.iter().next().unwrap();
                let max = *s.iter().next_back().unwrap();
                if max - min > r - l {
                    l = min;
                    r = max;
                }
                s.remove(&nums[l]);
                l += 1;
            }
            ans += (r - l + 1) as i64;
        }
        ans
    }
}