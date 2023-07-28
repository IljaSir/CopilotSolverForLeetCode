impl Solution {
    pub fn max_performance(n: i32, speed: Vec<i32>, efficiency: Vec<i32>, k: i32) -> i32 {
        
        let mut engineers: Vec<(i32, i32)> = speed.into_iter().zip(efficiency.into_iter()).collect();
        engineers.sort_by(|a, b| b.1.cmp(&a.1));
        let mut heap: std::collections::BinaryHeap<std::cmp::Reverse<i32>> = std::collections::BinaryHeap::new();
        let mut sum = 0;
        let mut ans = 0;
        for (speed, efficiency) in engineers {
            heap.push(std::cmp::Reverse(speed));
            sum += speed;
            if heap.len() > k as usize {
                sum -= heap.pop().unwrap().0;
            }
            ans = ans.max(sum * efficiency);
        }
        (ans % 1_000_000_007) as i32
    }
}