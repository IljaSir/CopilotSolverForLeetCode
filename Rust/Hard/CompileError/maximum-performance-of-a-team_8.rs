impl Solution {
    pub fn max_performance(n: i32, speed: Vec<i32>, efficiency: Vec<i32>, k: i32) -> i32 {
        
        let mut v = Vec::new();
        for i in 0..n {
            v.push((speed[i as usize], efficiency[i as usize]));
        }
        v.sort_by_key(|&(_, e)| -e);
        let mut sum = 0;
        let mut res = 0;
        let mut pq = std::collections::BinaryHeap::new();
        for (s, e) in v {
            sum += s;
            pq.push(-s);
            if pq.len() > k as usize {
                sum += pq.pop().unwrap();
            }
            res = res.max(sum * e as i64);
        }
        (res % 1000000007) as i32
    }
}