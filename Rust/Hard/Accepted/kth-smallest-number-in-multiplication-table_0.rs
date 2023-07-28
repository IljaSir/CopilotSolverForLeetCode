impl Solution {
    pub fn find_kth_number(m: i32, n: i32, k: i32) -> i32 {
        
        let (m, n, k) = (m as usize, n as usize, k as usize);
        let (mut l, mut r) = (1, m * n);
        while l < r {
            let mid = (l + r) >> 1;
            if Self::count(m, n, mid) < k {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        l as i32
    }
    
    fn count(m: usize, n: usize, x: usize) -> usize {
        let mut count = 0;
        for i in 1..=m {
            count += std::cmp::min(x / i, n);
        }
        count
    }
}