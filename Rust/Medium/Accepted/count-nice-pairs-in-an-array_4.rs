impl Solution {
    pub fn count_nice_pairs(nums: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut ans = 0;
        for &num in nums.iter() {
            let rev = Self::rev(num);
            let diff = num - rev;
            let count = map.entry(diff).or_insert(0);
            ans = (ans + *count) % 1000000007;
            *count += 1;
        }
        ans
    }
    pub fn rev(mut num: i32) -> i32 {
        let mut ans = 0;
        while num > 0 {
            ans = ans * 10 + num % 10;
            num /= 10;
        }
        ans
    }
}