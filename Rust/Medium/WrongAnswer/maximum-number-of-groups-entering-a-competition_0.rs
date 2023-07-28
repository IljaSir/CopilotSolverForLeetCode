impl Solution {
    pub fn maximum_groups(grades: Vec<i32>) -> i32 {
        
        let mut cnt = vec![0; 100001];
        for g in grades {
            cnt[g as usize] += 1;
        }
        let mut ans = 0;
        let mut sum = 0;
        let mut count = 0;
        for i in (1..cnt.len()).rev() {
            if cnt[i] > 0 {
                if count + cnt[i] > sum + i {
                    ans += 1;
                    sum = count;
                    count = 0;
                }
                count += cnt[i];
            }
        }
        ans
    }
}