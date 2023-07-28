impl Solution {
    pub fn is_possible(target: Vec<i32>) -> bool {
        
        let mut heap = std::collections::BinaryHeap::from(target);
        let mut sum = heap.iter().sum::<i32>();
        while let Some(&n) = heap.peek() {
            if n == 1 { return true; }
            let m = heap.pop().unwrap();
            let k = m - (sum - m);
            if k <= 0 || k == m { return false; }
            heap.push(k);
            sum = sum - m + k;
        }
        false
    }
}