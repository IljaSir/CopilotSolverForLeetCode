impl Solution {
    pub fn count_nice_pairs(nums: Vec<i32>) -> i32 {
        
        let m = 1_000_000_007;
        let mut map = std::collections::HashMap::new();
        let mut res = 0;
        for n in nums {
            let n = n as i64;
            let rev = Self::reverse(n);
            let diff = (n - rev) % m;
            let count = map.entry(diff).or_insert(0);
            res = (res + *count) % m;
            *count += 1;
        }
        res as i32
    }
    
    fn reverse(mut n: i64) -> i64 {
        let mut res = 0;
        while n > 0 {
            res = res * 10 + n % 10;
            n /= 10;
        }
        res
    }
}