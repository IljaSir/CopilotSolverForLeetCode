impl Solution {
    pub fn kth_smallest_path(destination: Vec<i32>, k: i32) -> String {
        
        let mut k = k;
        let mut ans = String::new();
        let mut h = destination[1];
        let mut v = destination[0];
        while h > 0 || v > 0 {
            if h == 0 {
                ans.push('V');
                v -= 1;
            } else if v == 0 {
                ans.push('H');
                h -= 1;
            } else {
                let mut cnt = 1;
                for i in 1..=h {
                    cnt *= v + i;
                    cnt /= i;
                    if cnt >= k {
                        break;
                    }
                }
                if cnt >= k {
                    ans.push('H');
                    h -= 1;
                } else {
                    ans.push('V');
                    v -= 1;
                    k -= cnt;
                }
            }
        }
        ans
    }
}