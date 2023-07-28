impl Solution {
    pub fn count_nice_pairs(nums: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut ans = 0;
        for i in nums.iter() {
            let t = Self::rev(*i);
            let x = (i - t).abs();
            *map.entry(x).or_insert(0) += 1;
        }
        let modu = 1000000007;
        for (_, v) in map.iter() {
            if *v > 1 {
                ans += (v * (v - 1)) / 2;
            }
        }
        ans as i32 % modu
    }
    pub fn rev(x: i32) -> i32 {
        let mut ans = 0;
        let mut x = x;
        while x > 0 {
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        ans
    }
}