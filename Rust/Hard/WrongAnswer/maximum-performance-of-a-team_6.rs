impl Solution {
    pub fn max_performance(n: i32, speed: Vec<i32>, efficiency: Vec<i32>, k: i32) -> i32 {
        
        let mut pairs: Vec<(i32, i32)> = speed.iter().zip(efficiency.iter()).map(|(s, e)| (*s, *e)).collect();
        pairs.sort_by_key(|(s, e)| -e);
        let mut heap: std::collections::BinaryHeap<i32> = std::collections::BinaryHeap::new();
        let mut sum = 0;
        let mut res = 0;
        for (s, e) in pairs {
            heap.push(-s);
            sum += s;
            if heap.len() > k as usize {
                sum += heap.pop().unwrap();
            }
            res = res.max(sum * e);
        }
        (res % (1e9 as i32 + 7)) as i32
    }
}