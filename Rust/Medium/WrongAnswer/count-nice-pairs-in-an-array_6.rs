impl Solution {
    pub fn count_nice_pairs(nums: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut count = 0;
        for n in nums {
            let r = Self::rev(n);
            let d = (n - r).abs();
            if let Some(v) = map.get(&d) {
                count += v;
                map.insert(d, v + 1);
            } else {
                map.insert(d, 1);
            }
        }
        (count % 1_000_000_007) as i32
    }
    fn rev(n: i32) -> i32 {
        let mut n = n;
        let mut r = 0;
        while n != 0 {
            r = r * 10 + n % 10;
            n /= 10;
        }
        r
    }
}