impl Solution {
    pub fn find_kth_number(n: i32, k: i32) -> i32 {
        
        let mut k = k;
        let mut curr = 1;
        while k > 1 {
            let steps = Solution::count_steps(n as i64, curr as i64, curr as i64 + 1);
            if steps < k {
                curr += 1;
                k -= steps;
            } else {
                curr *= 10;
                k -= 1;
            }
        }
        curr as i32
    }

    fn count_steps(n: i64, n1: i64, n2: i64) -> i32 {
        let mut steps = 0;
        let mut c1 = n1;
        let mut c2 = n2;
        while c1 <= n {
            steps += std::cmp::min(n + 1, c2) - c1;
            c1 *= 10;
            c2 *= 10;
        }
        steps as i32
    }
}