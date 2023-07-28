impl Solution {
    pub fn maximum_groups(grades: Vec<i32>) -> i32 {
        
        let mut arr = vec![0; 100001];
        for g in grades {
            arr[g as usize] += 1;
        }
        let mut ans = 0;
        let mut sum = 0;
        let mut cnt = 0;
        for i in 1..=100000 {
            if arr[i] > 0 {
                if sum + i > cnt + 1 {
                    ans += 1;
                    sum = 0;
                    cnt = 0;
                }
                sum += i;
                cnt += 1;
            }
        }
        ans
    }
}