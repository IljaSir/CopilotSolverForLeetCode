impl Solution {
    pub fn max_performance(n: i32, speed: Vec<i32>, efficiency: Vec<i32>, k: i32) -> i32 {
        
        let mut v: Vec<(i32, i32)> = speed.into_iter().zip(efficiency.into_iter()).collect();
        v.sort_by(|a, b| b.1.cmp(&a.1));
        let mut ans = 0;
        let mut sum = 0;
        let mut pq = std::collections::BinaryHeap::new();
        for (s, e) in v {
            sum += s;
            pq.push(-s);
            if pq.len() > k as usize {
                sum += pq.pop().unwrap();
            }
            ans = ans.max(sum * e);
        }
        (ans % 1000000007) as i32
    }
}