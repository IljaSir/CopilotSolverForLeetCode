impl Solution {
    pub fn count_distinct_integers(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut map = std::collections::HashMap::new();
        for num in nums.iter() {
            let mut num = *num;
            let mut rev = 0;
            while num > 0 {
                rev = rev * 10 + num % 10;
                num /= 10;
            }
            if !map.contains_key(&rev) {
                map.insert(rev, true);
                ans += 1;
            }
        }
        ans
    }
}