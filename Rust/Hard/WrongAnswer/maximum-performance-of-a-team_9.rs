impl Solution {
    pub fn max_performance(n: i32, speed: Vec<i32>, efficiency: Vec<i32>, k: i32) -> i32 {
        
        let k = k as usize;
        let mut engineers: Vec<(i32, i32)> = speed.into_iter().zip(efficiency.into_iter()).collect();
        engineers.sort_by_key(|e| -e.1);
        let mut speed_heap = std::collections::BinaryHeap::new();
        let mut sum = 0;
        let mut ans = 0;
        for (s, e) in engineers {
            sum += s;
            speed_heap.push(-s);
            if speed_heap.len() > k {
                if let Some(&x) = speed_heap.peek() {
                    sum += x;
                }
                speed_heap.pop();
            }
            ans = ans.max(sum * e);
        }
        (ans % 1_000_000_007) as i32
    }
}