impl Solution {
    pub fn capture_forts(forts: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut i = 0;
        let mut j = 0;
        let n = forts.len();
        while j < n {
            while j < n && forts[j] == 0 {
                j += 1;
            }
            if j < n && forts[j] == 1 {
                let mut k = j + 1;
                while k < n && forts[k] == 0 {
                    k += 1;
                }
                if k < n && forts[k] == 1 {
                    ans = ans.max(k - i);
                }
                i = j;
                j = k;
            }
        }
        ans as i32
    }
}