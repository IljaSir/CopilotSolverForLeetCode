impl Solution {
    pub fn max_performance(n: i32, speed: Vec<i32>, efficiency: Vec<i32>, k: i32) -> i32 {
        
        let mut v = vec![];
        for i in 0..n {
            v.push((speed[i as usize], efficiency[i as usize]));
        }
        v.sort_by(|a, b| b.1.cmp(&a.1));
        let mut q = std::collections::BinaryHeap::new();
        let mut sum = 0;
        let mut ans = 0;
        for (s, e) in v {
            sum += s;
            q.push(s);
            if q.len() > k as usize {
                sum -= q.pop().unwrap();
            }
            ans = ans.max(sum * e);
        }
        (ans % 1_000_000_007) as i32
    }
}