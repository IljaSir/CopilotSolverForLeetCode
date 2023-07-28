impl Solution {
    pub fn max_performance(n: i32, speed: Vec<i32>, efficiency: Vec<i32>, k: i32) -> i32 {
        
        let mut v = Vec::new();
        for i in 0..n {
            v.push((speed[i as usize], efficiency[i as usize]));
        }
        v.sort_by(|a, b| b.1.cmp(&a.1));
        let mut ans = 0;
        let mut sum = 0;
        let mut heap = std::collections::BinaryHeap::new();
        for i in 0..n {
            sum += v[i as usize].0;
            heap.push(-v[i as usize].0);
            if heap.len() > k as usize {
                sum += heap.pop().unwrap();
            }
            ans = ans.max(sum * v[i as usize].1);
        }
        (ans % 1_000_000_007) as i32
    }
}