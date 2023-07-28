impl Solution {
    pub fn minimum_replacement(nums: Vec<i32>) -> i64 {
        
        use std::collections::BinaryHeap;
        let mut heap = BinaryHeap::new();
        let mut res = 0;
        for n in nums {
            if heap.len() == 0 {
                heap.push(n);
            } else {
                if heap.peek().unwrap() > &n {
                    res += 1;
                    heap.push(n);
                } else {
                    while heap.len() > 0 && heap.peek().unwrap() <= &n {
                        heap.pop();
                    }
                    heap.push(n);
                }
            }
        }
        res
    }
}