impl Solution {
    pub fn find_kth_number(m: i32, n: i32, k: i32) -> i32 {
        
        let mut l = 1;
        let mut r = m * n;
        while l < r {
            let mid = (l + r) / 2;
            if Solution::count(m, n, mid) < k {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        l
    }
    fn count(m: i32, n: i32, mid: i32) -> i32 {
        let mut res = 0;
        for i in 1..=m {
            res += std::cmp::min(n, mid / i);
        }
        res
    }
}