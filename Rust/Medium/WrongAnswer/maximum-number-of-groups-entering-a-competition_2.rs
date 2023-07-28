impl Solution {
    pub fn maximum_groups(grades: Vec<i32>) -> i32 {
        
        let mut freq = vec![0; 100001];
        for &grade in grades.iter() {
            freq[grade as usize] += 1;
        }
        let mut ans = 0;
        let mut sum = 0;
        let mut cnt = 0;
        for i in (1..100001).rev() {
            if freq[i] > 0 {
                if sum + i < sum || cnt + 1 < cnt {
                    ans += 1;
                    sum = 0;
                    cnt = 0;
                }
                sum += i * freq[i];
                cnt += freq[i];
            }
        }
        ans + 1
    }
}