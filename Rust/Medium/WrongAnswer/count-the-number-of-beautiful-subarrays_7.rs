impl Solution {
    pub fn beautiful_subarrays(nums: Vec<i32>) -> i64 {
        
        let mut ans: i64 = 0;
        let mut odd: Vec<i64> = vec![0];
        for n in nums {
            if n % 2 == 0 {
                *odd.last_mut().unwrap() += 1;
            } else {
                odd.push(1);
            }
        }
        for n in odd {
            ans += n * (n + 1) / 2;
        }
        ans
    }
}