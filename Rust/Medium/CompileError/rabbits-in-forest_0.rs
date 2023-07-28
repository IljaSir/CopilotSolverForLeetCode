impl Solution {
    pub fn num_rabbits(answers: Vec<i32>) -> i32 {
        
        let mut cnt = [0; 1000];
        for &x in &answers {
            cnt[x as usize] += 1;
        }
        let mut ans = 0;
        for i in 0..1000 {
            ans += (cnt[i] + i) / (i + 1) * (i + 1);
        }
        ans
    }
}