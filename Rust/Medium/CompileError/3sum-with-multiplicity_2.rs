impl Solution {
    pub fn three_sum_multi(arr: Vec<i32>, target: i32) -> i32 {
        
        let mut cnt = vec![0; 101];
        for &x in &arr {
            cnt[x as usize] += 1;
        }
        let mut ans = 0;
        for i in 0..101 {
            for j in i..101 {
                let k = target - i - j;
                if k < 0 || k > 100 {
                    continue;
                }
                if i == j && j == k {
                    ans += cnt[i] * (cnt[i] - 1) * (cnt[i] - 2) / 6;
                } else if i == j && j != k {
                    ans += cnt[i] * (cnt[i] - 1) / 2 * cnt[k];
                } else if i < j && j < k {
                    ans += cnt[i] * cnt[j] * cnt[k];
                }
            }
        }
        (ans % 1000000007) as i32
    }
}