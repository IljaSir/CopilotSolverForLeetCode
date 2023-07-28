impl Solution {
    pub fn find_kth_number(m: i32, n: i32, k: i32) -> i32 {
        
        let (m, n) = (m as usize, n as usize);
        let (mut l, mut r) = (1, m * n);
        while l < r {
            let mid = (l + r) >> 1;
            let cnt = (1..=n).map(|i| (mid / i).min(m)).sum::<usize>();
            if cnt < k {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        l as i32
    }
}