impl Solution {
    pub fn eaten_apples(apples: Vec<i32>, days: Vec<i32>) -> i32 {
        
        let mut min_heap = std::collections::BinaryHeap::new();
        let mut i = 0;
        let mut res = 0;
        while i < apples.len() || !min_heap.is_empty() {
            if i < apples.len() && apples[i] > 0 {
                min_heap.push((-(i as i32 + days[i]), apples[i]));
            }
            while !min_heap.is_empty() && (min_heap.peek().unwrap().0 + i as i32 < 0 || min_heap.peek().unwrap().1 == 0) {
                min_heap.pop();
            }
            if !min_heap.is_empty() {
                let (d, a) = min_heap.peek_mut().unwrap();
                *a -= 1;
                res += 1;
            }
            i += 1;
        }
        res
    }
}