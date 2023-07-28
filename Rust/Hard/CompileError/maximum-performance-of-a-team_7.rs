impl Solution {
    pub fn max_performance(n: i32, speed: Vec<i32>, efficiency: Vec<i32>, k: i32) -> i32 {
        
        let mut v = Vec::new();
        for i in 0..n {
            v.push((speed[i as usize], efficiency[i as usize]));
        }
        v.sort_by_key(|x| -(x.1 as i64));
        let mut q = std::collections::BinaryHeap::new();
        let mut res = 0;
        let mut sum = 0;
        for i in 0..n {
            let (s, e) = v[i as usize];
            q.push(s);
            sum += s;
            if q.len() > k as usize {
                sum -= q.pop().unwrap();
            }
            res = res.max(sum * e as i64);
        }
        (res % 1000000007) as i32
    }
}