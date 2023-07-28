impl Solution {
    pub fn max_performance(n: i32, speed: Vec<i32>, efficiency: Vec<i32>, k: i32) -> i32 {
        
        let mut vec = Vec::new();
        for i in 0..n as usize {
            vec.push((speed[i], efficiency[i]));
        }
        vec.sort_by(|a, b| b.1.cmp(&a.1));
        let mut heap = std::collections::BinaryHeap::new();
        let mut res = 0;
        let mut sum = 0;
        for i in 0..n as usize {
            sum += vec[i].0;
            heap.push(-vec[i].0);
            if heap.len() > k as usize {
                sum += heap.pop().unwrap();
            }
            res = std::cmp::max(res, sum * vec[i].1);
        }
        (res % 1000000007) as i32
    }
}