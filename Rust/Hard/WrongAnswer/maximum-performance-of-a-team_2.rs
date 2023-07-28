impl Solution {
    pub fn max_performance(n: i32, speed: Vec<i32>, efficiency: Vec<i32>, k: i32) -> i32 {
        
        let mut engineers = Vec::new();
        for i in 0..n {
            engineers.push((speed[i as usize], efficiency[i as usize]));
        }
        engineers.sort_by(|a, b| b.1.cmp(&a.1));
        let mut res = 0;
        let mut speed_sum = 0;
        let mut pq = std::collections::BinaryHeap::new();
        for i in 0..n {
            if pq.len() == k as usize {
                speed_sum -= pq.pop().unwrap();
            }
            speed_sum += engineers[i as usize].0;
            pq.push(engineers[i as usize].0);
            res = res.max(speed_sum * engineers[i as usize].1);
        }
        (res % 1_000_000_007) as i32
    }
}