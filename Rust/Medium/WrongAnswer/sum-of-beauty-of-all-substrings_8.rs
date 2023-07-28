impl Solution {
    pub fn beauty_sum(s: String) -> i32 {
        
        let mut sum = 0;
        let mut cnt = vec![0; 26];
        let mut max = vec![0; 26];
        let mut min = vec![0; 26];
        let mut arr = s.into_bytes();
        for i in 0..arr.len() {
            for j in 0..26 {
                cnt[j] = 0;
                max[j] = 0;
                min[j] = 0;
            }
            for j in i..arr.len() {
                let idx = arr[j] as usize - 'a' as usize;
                cnt[idx] += 1;
                if max[idx] == 0 {
                    max[idx] = cnt[idx];
                    min[idx] = cnt[idx];
                } else {
                    max[idx] = std::cmp::max(max[idx], cnt[idx]);
                    min[idx] = std::cmp::min(min[idx], cnt[idx]);
                }
                let mut m = 0;
                let mut n = 0;
                for k in 0..26 {
                    if max[k] > 0 {
                        if m == 0 {
                            m = max[k];
                        } else {
                            m = std::cmp::max(m, max[k]);
                        }
                        if n == 0 {
                            n = min[k];
                        } else {
                            n = std::cmp::min(n, min[k]);
                        }
                    }
                }
                sum += m - n;
            }
        }
        sum
    }
}