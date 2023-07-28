impl Solution {
    pub fn top_k_frequent(nums: Vec<i32>, k: i32) -> Vec<i32> {
        

        use std::collections::{HashMap, BinaryHeap};
        use std::cmp::Reverse;
        let mut map = HashMap::new();
        for num in nums {
            *map.entry(num).or_insert(0) += 1;
        }
        let mut pq = BinaryHeap::new();
        for (num, count) in map {
            pq.push((Reverse(count), num));
        }
        let mut res = Vec::new();
        for _ in 0..k {
            let (_, num) = pq.pop().unwrap();
            res.push(num);
        }
        res
    }
}