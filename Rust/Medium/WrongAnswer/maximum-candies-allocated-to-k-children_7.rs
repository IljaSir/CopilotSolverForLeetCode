impl Solution {
    pub fn maximum_candies(candies: Vec<i32>, k: i64) -> i32 {
        
        let mut candies = candies;
        candies.sort();
        let mut l = 0;
        let mut r = candies.len() - 1;
        let mut ans = 0;
        while l <= r {
            let mid = l + (r - l) / 2;
            if Solution::check(&candies, mid, k) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        ans as i32
    }

    fn check(candies: &Vec<i32>, mid: usize, k: i64) -> bool {
        let mut cnt = 0;
        for i in 0..candies.len() {
            if candies[i] as usize > mid {
                cnt += (candies[i] as usize - mid) as i64;
            }
        }
        cnt >= k
    }
}