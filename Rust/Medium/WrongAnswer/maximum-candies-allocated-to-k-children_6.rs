impl Solution {
    pub fn maximum_candies(candies: Vec<i32>, k: i64) -> i32 {
        
        let mut candies = candies;
        candies.sort();
        let mut l = 0;
        let mut r = candies.len() as i64;
        let mut ans = 0;
        while l <= r {
            let mid = (l + r) / 2;
            let mut cnt = 0;
            for i in (0..candies.len()).rev() {
                if candies[i] as i64 >= mid {
                    cnt += (candies[i] as i64 - mid + 1) * k;
                } else {
                    break;
                }
            }
            if cnt >= mid * k {
                ans = ans.max(mid as i32);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        ans
    }
}